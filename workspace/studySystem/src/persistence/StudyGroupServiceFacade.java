package persistence;

import model.*;

public class StudyGroupServiceFacade{



	public StudyGroupServiceFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentStudyGroupService newStudyGroupService(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentStudyGroupService)PersistentProxi.createProxi(idCreateIfLessZero, -302);
        long id = ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.getNextId();
        StudyGroupService result = new StudyGroupService(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudyGroupService)PersistentProxi.createProxi(id, -302);
    }
    
    public PersistentStudyGroupService newDelayedStudyGroupService() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.getNextId();
        StudyGroupService result = new StudyGroupService(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentStudyGroupService)PersistentProxi.createProxi(id, -302);
    }
    
    public StudyGroupService getStudyGroupService(long StudyGroupServiceId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void groupManagerSet(long StudyGroupServiceId, StudyGroupServiceGroupManager4Public groupManagerVal) throws PersistenceException {
        
    }

}

