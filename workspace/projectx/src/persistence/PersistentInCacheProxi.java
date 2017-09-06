package persistence;

import java.util.HashMap;

abstract class ICProxiFactory {
	  abstract PersistentInCacheProxi create(long objectId);
}

public abstract class PersistentInCacheProxi extends PersistentRoot {

	  private static ICProxiFactory [] iCProxiFactories;
		
	  private static ICProxiFactory [] getTheICProxiFactories(){
		if (iCProxiFactories == null){
			iCProxiFactories = new ICProxiFactory[170];
        iCProxiFactories[1] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ServerICProxi(objectId);
            }
        };
        iCProxiFactories[76] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ProgramSGroupICProxi(objectId);
            }
        };
        iCProxiFactories[77] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ModuleGroupSGroupICProxi(objectId);
            }
        };
        iCProxiFactories[78] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ModuleAtomarSGroupICProxi(objectId);
            }
        };
        iCProxiFactories[52] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ModuleAtomarICProxi(objectId);
            }
        };
        iCProxiFactories[124] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new T_3_7ICProxi(objectId);
            }
        };
        iCProxiFactories[111] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ThirdGradeSystemICProxi(objectId);
            }
        };
        iCProxiFactories[0] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandCoordinatorICProxi(objectId);
            }
        };
        iCProxiFactories[79] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new StudyGroupICProxi(objectId);
            }
        };
        iCProxiFactories[102] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AddStudentToGroupCommandICProxi(objectId);
            }
        };
        iCProxiFactories[116] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NoGradeThirdICProxi(objectId);
            }
        };
        iCProxiFactories[125] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_1_0ICProxi(objectId);
            }
        };
        iCProxiFactories[126] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_1_1ICProxi(objectId);
            }
        };
        iCProxiFactories[67] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AddModuleToProgCommandICProxi(objectId);
            }
        };
        iCProxiFactories[128] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_1_2ICProxi(objectId);
            }
        };
        iCProxiFactories[130] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_2_2ICProxi(objectId);
            }
        };
        iCProxiFactories[131] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_2_3ICProxi(objectId);
            }
        };
        iCProxiFactories[132] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_2_4ICProxi(objectId);
            }
        };
        iCProxiFactories[133] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_2_5ICProxi(objectId);
            }
        };
        iCProxiFactories[134] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_2_6ICProxi(objectId);
            }
        };
        iCProxiFactories[135] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_2_7ICProxi(objectId);
            }
        };
        iCProxiFactories[136] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_2_8ICProxi(objectId);
            }
        };
        iCProxiFactories[137] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_2_9ICProxi(objectId);
            }
        };
        iCProxiFactories[99] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateStudentCommandICProxi(objectId);
            }
        };
        iCProxiFactories[100] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new StudentManagerICProxi(objectId);
            }
        };
        iCProxiFactories[94] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new StudentICProxi(objectId);
            }
        };
        iCProxiFactories[58] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateModuleCommandICProxi(objectId);
            }
        };
        iCProxiFactories[121] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new T_2_3ICProxi(objectId);
            }
        };
        iCProxiFactories[122] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new T_2_0ICProxi(objectId);
            }
        };
        iCProxiFactories[139] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new T_2_7ICProxi(objectId);
            }
        };
        iCProxiFactories[96] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new UnitStudentICProxi(objectId);
            }
        };
        iCProxiFactories[3] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommonDateICProxi(objectId);
            }
        };
        iCProxiFactories[81] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ModuleWithUnitsSGroupICProxi(objectId);
            }
        };
        iCProxiFactories[55] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeCPOnModuleCommandICProxi(objectId);
            }
        };
        iCProxiFactories[90] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ModuleAtomarStudentICProxi(objectId);
            }
        };
        iCProxiFactories[53] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ModuleWithUnitsICProxi(objectId);
            }
        };
        iCProxiFactories[91] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ProgramStudentICProxi(objectId);
            }
        };
        iCProxiFactories[143] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_1_3ICProxi(objectId);
            }
        };
        iCProxiFactories[144] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_5_0ICProxi(objectId);
            }
        };
        iCProxiFactories[146] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_1_4ICProxi(objectId);
            }
        };
        iCProxiFactories[148] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_1_5ICProxi(objectId);
            }
        };
        iCProxiFactories[92] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ModuleWithUnitsStudentICProxi(objectId);
            }
        };
        iCProxiFactories[150] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_1_6ICProxi(objectId);
            }
        };
        iCProxiFactories[152] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_1_7ICProxi(objectId);
            }
        };
        iCProxiFactories[154] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_1_8ICProxi(objectId);
            }
        };
        iCProxiFactories[156] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_1_9ICProxi(objectId);
            }
        };
        iCProxiFactories[110] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeGradeSystemCommandICProxi(objectId);
            }
        };
        iCProxiFactories[93] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ModuleGroupStudentICProxi(objectId);
            }
        };
        iCProxiFactories[56] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeCPOnUnitCommandICProxi(objectId);
            }
        };
        iCProxiFactories[161] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new T_3_0ICProxi(objectId);
            }
        };
        iCProxiFactories[162] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new T_3_3ICProxi(objectId);
            }
        };
        iCProxiFactories[4] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CommandExecuterICProxi(objectId);
            }
        };
        iCProxiFactories[113] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new PassedICProxi(objectId);
            }
        };
        iCProxiFactories[54] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new CreateProgramCommandICProxi(objectId);
            }
        };
        iCProxiFactories[43] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ErrorDisplayICProxi(objectId);
            }
        };
        iCProxiFactories[84] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new StartStudyGroupCommandICProxi(objectId);
            }
        };
        iCProxiFactories[44] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ModuleManagerICProxi(objectId);
            }
        };
        iCProxiFactories[65] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ModuleGroupICProxi(objectId);
            }
        };
        iCProxiFactories[46] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new UnitICProxi(objectId);
            }
        };
        iCProxiFactories[68] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AddModuleToGroupCommandICProxi(objectId);
            }
        };
        iCProxiFactories[47] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ProgramManagerICProxi(objectId);
            }
        };
        iCProxiFactories[127] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_3_0ICProxi(objectId);
            }
        };
        iCProxiFactories[112] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new SimpleGradeSystemICProxi(objectId);
            }
        };
        iCProxiFactories[129] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_4_0ICProxi(objectId);
            }
        };
        iCProxiFactories[42] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ProgramICProxi(objectId);
            }
        };
        iCProxiFactories[166] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeGradeOfUnitCommandICProxi(objectId);
            }
        };
        iCProxiFactories[80] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new UnitSGroupICProxi(objectId);
            }
        };
        iCProxiFactories[138] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new T_4_0ICProxi(objectId);
            }
        };
        iCProxiFactories[85] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new StudyGroupManagerICProxi(objectId);
            }
        };
        iCProxiFactories[169] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new ChangeGradeOfModuleCommandICProxi(objectId);
            }
        };
        iCProxiFactories[60] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new AddUnitCommandICProxi(objectId);
            }
        };
        iCProxiFactories[87] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new SwapCPonModuleWithUnitsCommandICProxi(objectId);
            }
        };
        iCProxiFactories[118] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NotPassedICProxi(objectId);
            }
        };
        iCProxiFactories[140] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_2_0ICProxi(objectId);
            }
        };
        iCProxiFactories[141] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_2_1ICProxi(objectId);
            }
        };
        iCProxiFactories[142] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_3_1ICProxi(objectId);
            }
        };
        iCProxiFactories[145] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_3_2ICProxi(objectId);
            }
        };
        iCProxiFactories[147] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_3_3ICProxi(objectId);
            }
        };
        iCProxiFactories[149] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_3_4ICProxi(objectId);
            }
        };
        iCProxiFactories[151] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_3_5ICProxi(objectId);
            }
        };
        iCProxiFactories[153] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_3_6ICProxi(objectId);
            }
        };
        iCProxiFactories[155] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_3_7ICProxi(objectId);
            }
        };
        iCProxiFactories[157] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_3_8ICProxi(objectId);
            }
        };
        iCProxiFactories[158] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new Z_3_9ICProxi(objectId);
            }
        };
        iCProxiFactories[160] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new T_5_0ICProxi(objectId);
            }
        };
        iCProxiFactories[167] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new NoGradeTenthICProxi(objectId);
            }
        };
        iCProxiFactories[119] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new T_1_3ICProxi(objectId);
            }
        };
        iCProxiFactories[123] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new T_1_7ICProxi(objectId);
            }
        };
        iCProxiFactories[120] = new ICProxiFactory(){
            PersistentInCacheProxi create(long objectId){
                return new T_1_0ICProxi(objectId);
            }
        };
		}
		return iCProxiFactories;
	  }

	public static PersistentInCacheProxi createInCacheProxi(long objectId, long classId) throws PersistenceException {
	    int index = (int) classId;
		if (index < 0) index = index * -1;
	    index = index - 101;
	    if (index > getTheICProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    ICProxiFactory factory = getTheICProxiFactories()[index];
	    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
	    PersistentInCacheProxi result =  factory.create(objectId);
	    return result;
	}

	protected PersistentObject object;
  	public int userCount;
	
	protected PersistentInCacheProxi(long id) {
		super(id);
		this.userCount = 0;
	}

	public PersistentInCacheProxi(PersistentObject object) {
		this(object.getId());
	}
	
	public boolean isDelayed$Persistence() throws PersistenceException {
		return this.getTheObject().isDelayed$Persistence();
	}

	public void setDelayed$Persistence(boolean b) throws PersistenceException {
		this.getTheObject().setDelayed$Persistence(b);
	}
	public void store() throws PersistenceException{
		this.getTheObject().store();
	}

	public void setId(long id) {
		super.setId(id);
		try {
			this.getTheObject().setId(id);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}
	public HashMap<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(depth, essentialLevel, forGUI);
	}
	public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
		PersistentRoot object = this.getTheObject();
		if (object == null) return null;
		return object.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, inDerived);
	}

	protected abstract PersistentObject getRemote() throws PersistenceException;

	public synchronized PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) this.object = getRemote();
		return this.object;
	}		
	protected synchronized void setObject(PersistentObject object) throws PersistenceException {
		this.object = object;
	}
	protected synchronized void clear() throws PersistenceException {
		this.object = null;
	}
	public int getIconInfo() throws PersistenceException {
		return this.getTheObject().getIconInfo();
	}
	public int getLeafInfo() throws PersistenceException {
		return this.getTheObject().getLeafInfo();
	}
	public String toString() {
		try {
			return this.getTheObject().toString();
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}
	}
	public String toString(boolean inner)throws PersistenceException{
		try {
			return this.getTheObject().toString(inner);
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}		
	}

	public synchronized void incrementUserCount() {
		this.userCount++;
	}

	public static long recycleCounter = 0;
	public synchronized void decrementUserCount() {
		this.userCount--;
		if (this.isRemovable()){
			Cache.getTheCache().remove(this);
			PersistentInCacheProxi.recycleCounter ++;
		}
	}

	protected boolean isRemovable() {
		return this.userCount <= 0 ;
	}
	public synchronized void tryBreak() {
		try {
			if (!this.isDelayed$Persistence())this.object = null;
		} catch (PersistenceException e) {
			return;
		}
	}

	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
	}
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	public Anything getThis() throws PersistenceException {
		return this.getTheObject().getThis();
	}
	
    
}
