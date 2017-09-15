package persistence;

import model.*;

public class DozentenServiceFacade{



	public DozentenServiceFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentDozentenService newDozentenService(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentDozentenService)PersistentProxi.createProxi(idCreateIfLessZero, -287);
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        DozentenService result = new DozentenService(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentDozentenService)PersistentProxi.createProxi(id, -287);
    }
    
    public PersistentDozentenService newDelayedDozentenService() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        DozentenService result = new DozentenService(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentDozentenService)PersistentProxi.createProxi(id, -287);
    }
    
    public DozentenService getDozentenService(long DozentenServiceId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void programManagerSet(long DozentenServiceId, ProgramManager4Public programManagerVal) throws PersistenceException {
        
    }
    public void moduleManagerSet(long DozentenServiceId, ModuleManager4Public moduleManagerVal) throws PersistenceException {
        
    }
    public void groupManagerSet(long DozentenServiceId, StudyGroupManager4Public groupManagerVal) throws PersistenceException {
        
    }
    public void studentManagerSet(long DozentenServiceId, StudentManager4Public studentManagerVal) throws PersistenceException {
        
    }

}

