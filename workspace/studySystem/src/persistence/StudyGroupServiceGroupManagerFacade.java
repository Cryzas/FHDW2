package persistence;

import model.*;

public class StudyGroupServiceGroupManagerFacade{

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

	

	public StudyGroupServiceGroupManagerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudyGroupServiceGroupManager newStudyGroupServiceGroupManager(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentStudyGroupServiceGroupManager)PersistentProxi.createProxi(idCreateIfLessZero, 308);
        long id = ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade.getNextId();
        StudyGroupServiceGroupManager result = new StudyGroupServiceGroupManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudyGroupServiceGroupManager)PersistentProxi.createProxi(id, 308);
    }
    
    public PersistentStudyGroupServiceGroupManager newDelayedStudyGroupServiceGroupManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade.getNextId();
        StudyGroupServiceGroupManager result = new StudyGroupServiceGroupManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudyGroupServiceGroupManager)PersistentProxi.createProxi(id, 308);
    }
    
    public StudyGroupServiceGroupManager getStudyGroupServiceGroupManager(long StudyGroupServiceGroupManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 308)) return 308;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void observerSet(long StudyGroupServiceGroupManagerId, StudyGroupService4Public observerVal) throws PersistenceException {
        
    }
    public void observeeSet(long StudyGroupServiceGroupManagerId, StudyGroupManager4Public observeeVal) throws PersistenceException {
        
    }
    public void ThisSet(long StudyGroupServiceGroupManagerId, StudyGroupServiceGroupManager4Public ThisVal) throws PersistenceException {
        
    }

}

