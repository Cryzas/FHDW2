package persistence;

import java.util.Hashtable;
import modelServer.ServerReporter;
import persistence.PersistentInCacheProxi;

public class Cache {

	protected static final long GarbageCollectorReportInterval = 60000;
		
	private static final long HeapSpaceAllocatable = Runtime.getRuntime().maxMemory();
	private static final long HeapSpaceReserve = HeapSpaceAllocatable / 8;

	private long heapSpaceFree;

	private static Cache theCache = null;

		
	public static Cache getTheCache() {
		if (theCache == null) theCache = new Cache();
		return theCache;
	}

	private Hashtable<Long, Hashtable<Long, PersistentInCacheProxi>> classMap;
	private Hashtable<Integer,String> number2NameMap;
	
	private static ServerReporter reporter; 
	public static void setReporter(ServerReporter theReporter){
		reporter = theReporter;
	}

	private Thread garbageCollector;
	Object lock = new Object();

	private Integer size = 0;
	private void sizeDecrement() {
		synchronized (size) {
			size--;
		}
	}
	private void sizeIncrement() {
		synchronized (size) {
			size++;
		}
	}

	public boolean forced = false;
	
	private Cache() {
		this.heapSpaceFree = Long.MAX_VALUE;
		this.classMap = new Hashtable<Long, Hashtable<Long, PersistentInCacheProxi>>();
		this.initializeNumber2NameMap();
		this.garbageCollector = new Thread(new Runnable(){

			public void run() {
				while (!garbageCollector.isInterrupted()){
					synchronized(lock){try {lock.wait(GarbageCollectorReportInterval);} catch (InterruptedException e) {return;}}//Do nothing and terminate!
					reporter.reportCurrentCacheSize(size, PersistentInCacheProxi.recycleCounter);
					if (Cache.this.heapSpaceFree < HeapSpaceReserve | forced){
						forced = false;
 						System.out.println("Free heap space: " + Cache.this.heapSpaceFree);
						Cache.this.heapSpaceFree = Long.MAX_VALUE;
						Object[] classes = classMap.keySet().toArray();
						for (int i = 0; i < classes.length; i++){
							long currentKey = (Long) classes[i];
							if (currentKey > 0){
								Hashtable<Long, PersistentInCacheProxi> objectMap = classMap.get(classes[i]);
								Object[] objects = objectMap.keySet().toArray();
								for (int j = 0; j < objects.length; j++){
									PersistentInCacheProxi current = objectMap.get(objects[j]);
									if (current != null) current.tryBreak();
								}
							}
						}
						System.gc();
					}
				}
			}
		},"Cache Garbage Collector");
		this.garbageCollector.setPriority(Thread.MAX_PRIORITY);
		this.garbageCollector.start();
	}

	public void reset$For$Test(){
		this.garbageCollector.interrupt();
		Cache.theCache = null;
	}

	public void finalize(){
		this.garbageCollector.interrupt();
	}

	public boolean contains(long objectId, long classId){
		Hashtable<Long, PersistentInCacheProxi> objectMap;
		objectMap = this.classMap.get(new Long(classId));
		if (objectMap == null) return false;
		PersistentInCacheProxi object;
		object = objectMap.get(new Long(objectId));
		return object != null;
	}

	
	public PersistentInCacheProxi get(PersistentProxiInterface proxi)
			throws PersistenceException {
		PersistentInCacheProxi object;
		Long classKey = new Long(proxi.getClassId());
		Long objectKey = new Long(proxi.getId());
		if(objectKey < 0)objectKey = objectKey * -1;
		Hashtable<Long, PersistentInCacheProxi> objectMap;
		synchronized(this.classMap){
			objectMap = this.classMap.get(classKey);
			if (objectMap == null) {
				objectMap = new Hashtable<Long, PersistentInCacheProxi>();
				this.classMap.put(classKey, objectMap);
			}
		}
		synchronized (objectMap){
			object = objectMap.get(objectKey);
			if (object == null) {
				object = PersistentInCacheProxi.createInCacheProxi(objectKey, proxi.getClassId());
				objectMap.put(objectKey, object);
				sizeIncrement();
				this.tryTriggerGC();
			}
		}
		return object;
	}
	private void tryTriggerGC(){
		synchronized(lock){
//			long heapSpaceAllocated = Runtime.getRuntime().totalMemory();
//			long unusedHeapSpace = HeapSpaceAllocatable - heapSpaceAllocated;
//			long freeInAllocatedHeapSpace = Runtime.getRuntime().freeMemory();
//			this.heapSpaceFree = freeInAllocatedHeapSpace + unusedHeapSpace;

			this.heapSpaceFree = Runtime.getRuntime().freeMemory() + (HeapSpaceAllocatable - Runtime.getRuntime().totalMemory());
			
			if (this.heapSpaceFree < HeapSpaceReserve) lock.notify();
		}
	}
	public synchronized PersistentInCacheProxi put(PersistentObject object)
			throws PersistenceException {
		Long classKey = new Long(object.getClassId());
		Long objectKey = new Long(object.getId());
		Hashtable<Long, PersistentInCacheProxi> objectMap;
		synchronized (this.classMap){
			objectMap = this.classMap.get(classKey);
			if (objectMap == null) {
				objectMap = new Hashtable<Long, PersistentInCacheProxi>();
				this.classMap.put(classKey, objectMap);
			}
		}
		PersistentInCacheProxi inCache;
		synchronized (objectMap){
			if (objectMap.containsKey(objectKey)) {
				inCache = objectMap.get(objectKey);
			} else {
				inCache = PersistentInCacheProxi.createInCacheProxi(object.getId(),object.getClassId());
				objectMap.put(objectKey, inCache);
				sizeIncrement();
			}
		}
		inCache.setObject(object);
		this.tryTriggerGC();
		return inCache;
	}
	
	/** Used in fake mode only
	*/
	protected PersistentInCacheProxi putSingleton(PersistentObject candidate) throws PersistenceException{
		PersistentInCacheProxi incache;
		Long classKey = new Long(candidate.getClassId());
		Hashtable<Long, PersistentInCacheProxi> objectMap;
		synchronized (this.classMap){
			objectMap = this.classMap.get(classKey);
			if (objectMap == null) {
				objectMap = new Hashtable<Long, PersistentInCacheProxi>();
				this.classMap.put(classKey, objectMap);
			}
		}
		synchronized (objectMap) {
			if (objectMap.size() == 0)return this.put(candidate);
			incache = objectMap.values().iterator().next();			
		}
		if (incache.getTheObject() != null)return incache;
		incache.setObject(candidate);
		return incache;
	}
	/** Used in fake mode only
	*/
	protected java.util.Iterator<PersistentInCacheProxi> iterator(long classNo){
		Long classKey = new Long(classNo);
		Hashtable<Long, PersistentInCacheProxi> objectMap = this.classMap.get(classKey);
		if (objectMap == null) {
			objectMap = new Hashtable<Long, PersistentInCacheProxi>();
			this.classMap.put(classKey, objectMap);
		}
		return objectMap.values().iterator();		
	}

	protected void release(PersistentProxiInterface object) throws PersistenceException  {
		PersistentInCacheProxi objectInCache;
		Long classKey = new Long(object.getClassId());
		Long objectKey = new Long(object.getId());
		Hashtable<Long, PersistentInCacheProxi> objectMap;
		objectMap = this.classMap.get(classKey);
		if (objectMap == null)return;
		objectInCache = (PersistentInCacheProxi) objectMap.get(objectKey);
		if (objectInCache == null)return;
		objectInCache.clear();
	}
	public void remove(PersistentInCacheProxi proxi) {
		Long classId = new Long(proxi.getClassId());
		Long objectId = new Long(proxi.getId());
		Hashtable<Long, PersistentInCacheProxi> objectMap = this.classMap.get(classId);
		objectMap.remove(objectId);
		sizeDecrement();
	}
	
/* ********************* Cache report ********************** */	

	public String getChacheReport(){
		return this.getCacheInfo().toString();
	}
	private CacheReport getCacheInfo() {
		CacheReport result = new CacheReport();
		for (Long current : this.classMap.keySet()) {
			result.addEntry(this.number2NameMap.get((int)current.longValue()),this.classMap.get(current).size());
		}
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public java.util.Vector getCacheReportList(){
		return new java.util.Vector(getCacheInfo().show());
	}
	class CacheReport {
		class CacheReportEntry implements Comparable<CacheReportEntry>{
			final String typeName;
			final int numberOfObjects;
			CacheReportEntry(String typeName, int numberOfObjects){
				this.typeName = typeName;
				this.numberOfObjects = numberOfObjects;
			}
			public int compareTo(CacheReportEntry o) {
				int result = new Integer(o.numberOfObjects).compareTo(this.numberOfObjects);
				if (result == 0) result = o.typeName.compareTo(this.typeName);
				return result;
			}
			public String toString(){
				return this.typeName + ": " + this.numberOfObjects;
			}
		}
		java.util.TreeSet<CacheReportEntry> data = new java.util.TreeSet<CacheReportEntry>();
		public void addEntry(String typeName, int numberOfObjects) {
			this.data.add(new CacheReportEntry(typeName, numberOfObjects));
		}
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public java.util.Vector show(){
			java.util.Vector result = new java.util.Vector();
			for (CacheReportEntry current : this.data) {
				result.add(current);
			}
			return result;
		}
		public String toString(){
			StringBuffer result = new StringBuffer();
			for (CacheReportEntry current : this.data) {
				result.append(current.toString() + "\n");
			}
			return result.toString();
		}
		
	}
	
	private void initializeNumber2NameMap() {
		this.number2NameMap = new Hashtable<Integer,String>();
		this.number2NameMap.put(169, "AddModuleToGroupCommand");
		this.number2NameMap.put(168, "AddModuleToProgCommand");
		this.number2NameMap.put(203, "AddStudentToGroupCommand");
		this.number2NameMap.put(161, "AddUnitCommand");
		this.number2NameMap.put(282, "BFalse");
		this.number2NameMap.put(281, "BTrue");
		this.number2NameMap.put(156, "ChangeCPOnModuleCommand");
		this.number2NameMap.put(157, "ChangeCPOnUnitCommand");
		this.number2NameMap.put(275, "ChangeGradeCommand");
		this.number2NameMap.put(211, "ChangeGradeSystemCommand");
		this.number2NameMap.put(-101, "CommandCoordinator");
		this.number2NameMap.put(-105, "CommandExecuter");
		this.number2NameMap.put(104, "CommonDate");
		this.number2NameMap.put(159, "CreateModuleCommand");
		this.number2NameMap.put(155, "CreateProgramCommand");
		this.number2NameMap.put(200, "CreateStudentCommand");
		this.number2NameMap.put(284, "EndStudyGroupCommand");
		this.number2NameMap.put(-144, "ErrorDisplay");
		this.number2NameMap.put(276, "GradeChange");
		this.number2NameMap.put(153, "ModuleAtomar");
		this.number2NameMap.put(179, "ModuleAtomarSGroup");
		this.number2NameMap.put(191, "ModuleAtomarStudent");
		this.number2NameMap.put(166, "ModuleGroup");
		this.number2NameMap.put(178, "ModuleGroupSGroup");
		this.number2NameMap.put(194, "ModuleGroupStudent");
		this.number2NameMap.put(145, "ModuleManager");
		this.number2NameMap.put(154, "ModuleWithUnits");
		this.number2NameMap.put(182, "ModuleWithUnitsSGroup");
		this.number2NameMap.put(193, "ModuleWithUnitsStudent");
		this.number2NameMap.put(273, "NoGrade");
		this.number2NameMap.put(285, "NoProgram");
		this.number2NameMap.put(219, "NotPassed");
		this.number2NameMap.put(214, "Passed");
		this.number2NameMap.put(143, "Program");
		this.number2NameMap.put(148, "ProgramManager");
		this.number2NameMap.put(177, "ProgramSGroup");
		this.number2NameMap.put(192, "ProgramStudent");
		this.number2NameMap.put(-102, "Server");
		this.number2NameMap.put(213, "SimpleGradeSystem");
		this.number2NameMap.put(185, "StartStudyGroupCommand");
		this.number2NameMap.put(195, "Student");
		this.number2NameMap.put(201, "StudentManager");
		this.number2NameMap.put(180, "StudyGroup");
		this.number2NameMap.put(186, "StudyGroupManager");
		this.number2NameMap.put(188, "SwapCPonModuleWithUnitsCommand");
		this.number2NameMap.put(221, "T_1_0");
		this.number2NameMap.put(220, "T_1_3");
		this.number2NameMap.put(224, "T_1_7");
		this.number2NameMap.put(223, "T_2_0");
		this.number2NameMap.put(222, "T_2_3");
		this.number2NameMap.put(240, "T_2_7");
		this.number2NameMap.put(262, "T_3_0");
		this.number2NameMap.put(263, "T_3_3");
		this.number2NameMap.put(225, "T_3_7");
		this.number2NameMap.put(239, "T_4_0");
		this.number2NameMap.put(261, "T_5_0");
		this.number2NameMap.put(212, "ThirdGradeSystem");
		this.number2NameMap.put(147, "Unit");
		this.number2NameMap.put(181, "UnitSGroup");
		this.number2NameMap.put(197, "UnitStudent");
		this.number2NameMap.put(226, "Z_1_0");
		this.number2NameMap.put(227, "Z_1_1");
		this.number2NameMap.put(229, "Z_1_2");
		this.number2NameMap.put(244, "Z_1_3");
		this.number2NameMap.put(247, "Z_1_4");
		this.number2NameMap.put(249, "Z_1_5");
		this.number2NameMap.put(251, "Z_1_6");
		this.number2NameMap.put(253, "Z_1_7");
		this.number2NameMap.put(255, "Z_1_8");
		this.number2NameMap.put(257, "Z_1_9");
		this.number2NameMap.put(241, "Z_2_0");
		this.number2NameMap.put(242, "Z_2_1");
		this.number2NameMap.put(231, "Z_2_2");
		this.number2NameMap.put(232, "Z_2_3");
		this.number2NameMap.put(233, "Z_2_4");
		this.number2NameMap.put(234, "Z_2_5");
		this.number2NameMap.put(235, "Z_2_6");
		this.number2NameMap.put(236, "Z_2_7");
		this.number2NameMap.put(237, "Z_2_8");
		this.number2NameMap.put(238, "Z_2_9");
		this.number2NameMap.put(228, "Z_3_0");
		this.number2NameMap.put(243, "Z_3_1");
		this.number2NameMap.put(246, "Z_3_2");
		this.number2NameMap.put(248, "Z_3_3");
		this.number2NameMap.put(250, "Z_3_4");
		this.number2NameMap.put(252, "Z_3_5");
		this.number2NameMap.put(254, "Z_3_6");
		this.number2NameMap.put(256, "Z_3_7");
		this.number2NameMap.put(258, "Z_3_8");
		this.number2NameMap.put(259, "Z_3_9");
		this.number2NameMap.put(230, "Z_4_0");
		this.number2NameMap.put(245, "Z_5_0");	
	}
	
}
