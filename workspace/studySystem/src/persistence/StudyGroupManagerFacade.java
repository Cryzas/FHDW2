package persistence;

import model.*;

public class StudyGroupManagerFacade{

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

	

	public StudyGroupManagerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudyGroupManager newStudyGroupManager(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentStudyGroupManager)PersistentProxi.createProxi(idCreateIfLessZero, 186);
        long id = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade.getNextId();
        StudyGroupManager result = new StudyGroupManager(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudyGroupManager)PersistentProxi.createProxi(id, 186);
    }
    
    public PersistentStudyGroupManager newDelayedStudyGroupManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade.getNextId();
        StudyGroupManager result = new StudyGroupManager(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudyGroupManager)PersistentProxi.createProxi(id, 186);
    }
    
    public StudyGroupManager getStudyGroupManager(long StudyGroupManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 186)) return 186;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long groupsAdd(long StudyGroupManagerId, StudyGroup4Public groupsVal) throws PersistenceException {
        return 0;
    }
    public void groupsRem(long groupsId) throws PersistenceException {
        
    }
    public StudyGroupList groupsGet(long StudyGroupManagerId) throws PersistenceException {
        return new StudyGroupList(); // remote access for initialization only!
    }
    public void subServiceSet(long StudyGroupManagerId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long StudyGroupManagerId, StudyGroupManager4Public ThisVal) throws PersistenceException {
        
    }

}

