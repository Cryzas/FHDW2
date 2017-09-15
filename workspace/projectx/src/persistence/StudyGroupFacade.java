package persistence;

import model.*;

public class StudyGroupFacade{

	static private Long sequencer = new Long(0);

	static protected long getTheNextId(){
		long result = -1;
		synchronized (sequencer) { 
			result = sequencer.longValue() + 1;
			sequencer = new Long(result);
		}
		return result;
	}

	protected long getNextId(){
		return getTheNextId();
	}

	

	public StudyGroupFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudyGroup newStudyGroup(String name,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentStudyGroup)PersistentProxi.createProxi(idCreateIfLessZero, 180);
        long id = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.getNextId();
        StudyGroup result = new StudyGroup(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudyGroup)PersistentProxi.createProxi(id, 180);
    }
    
    public PersistentStudyGroup newDelayedStudyGroup(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.getNextId();
        StudyGroup result = new StudyGroup(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudyGroup)PersistentProxi.createProxi(id, 180);
    }
    
    public StudyGroup getStudyGroup(long StudyGroupId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 180)) return 180;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public StudyGroupSearchList getStudyGroupByName(String name) throws PersistenceException {
        name = name.replaceAll("\\\\", "\\\\\\\\");
        name = name.replaceAll("\\?", "\\\\?");
        name = name.replaceAll("\\+", "\\\\+");
        name = name.replaceAll("\\*", "\\\\*");
        name = name.replaceAll("\\[", "\\\\[");
        name = name.replaceAll("\\]", "\\\\]");
        name = name.replaceAll("\\{", "\\\\{");
        name = name.replaceAll("\\}", "\\\\}");
        name = name.replaceAll("\\&", "\\\\&");
        name = name.replaceAll("\\-", "\\\\-");
        name = name.replaceAll("@@", "@-");
        name = name.replaceAll("%", "%-");
        name = name.replaceAll("_", "_-");
        name = name.replaceAll("@_-", "_");
        name = name.replaceAll("@%-", "%");
        name = name.replaceAll("@-", "@");
        name = name.replaceAll("%-", ".*");
        name = name.replaceAll("_-", ".");
        StudyGroupSearchList result = new StudyGroupSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(180);
        while (candidates.hasNext()){
            PersistentStudyGroup current = (PersistentStudyGroup)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getName().matches(name))
                result.add((PersistentStudyGroup)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long StudyGroupId, String nameVal) throws PersistenceException {
        
    }
    public void programSet(long StudyGroupId, ProgramSGroup4Public programVal) throws PersistenceException {
        
    }
    public long studentsAdd(long StudyGroupId, Student4Public studentsVal) throws PersistenceException {
        return 0;
    }
    public void studentsRem(long studentsId) throws PersistenceException {
        
    }
    public StudentList studentsGet(long StudyGroupId) throws PersistenceException {
        return new StudentList(); // remote access for initialization only!
    }
    public void finishedSet(long StudyGroupId, MyBoolean4Public finishedVal) throws PersistenceException {
        
    }
    public void ThisSet(long StudyGroupId, StudyGroup4Public ThisVal) throws PersistenceException {
        
    }
    public StudyGroupSearchList inverseGetStudents(long objectId, long classId)throws PersistenceException{
        StudyGroupSearchList result = new StudyGroupSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(180);
        while (candidates.hasNext()){
            PersistentStudyGroup current = (PersistentStudyGroup)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null){
                java.util.Iterator<Student4Public> iterator = ((StudyGroup_StudentsProxi)current.getStudents()).iterator();
                while(iterator.hasNext()){
                    PersistentProxi item = (PersistentProxi)iterator.next();
                    if (!item.isDltd() && !current.isDelayed$Persistence() && item.getClassId() == classId && item.getId() == objectId) {
                        PersistentStudyGroup proxi = (PersistentStudyGroup)PersistentProxi.createProxi(current.getId(), current.getClassId());
                        result.add((PersistentStudyGroup)proxi.getThis());
                    }
                }
            }
        }
        return result;
    }

}

