package persistence;

import model.*;

public class ProgramModuleServiceFacade{



	public ProgramModuleServiceFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProgramModuleService newProgramModuleService(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentProgramModuleService)PersistentProxi.createProxi(idCreateIfLessZero, -305);
        long id = ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.getNextId();
        ProgramModuleService result = new ProgramModuleService(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramModuleService)PersistentProxi.createProxi(id, -305);
    }
    
    public PersistentProgramModuleService newDelayedProgramModuleService() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.getNextId();
        ProgramModuleService result = new ProgramModuleService(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgramModuleService)PersistentProxi.createProxi(id, -305);
    }
    
    public ProgramModuleService getProgramModuleService(long ProgramModuleServiceId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void programManagerSet(long ProgramModuleServiceId, ProgramModuleServiceProgramManager4Public programManagerVal) throws PersistenceException {
        
    }
    public void moduleManagerSet(long ProgramModuleServiceId, ProgramModuleServiceModuleManager4Public moduleManagerVal) throws PersistenceException {
        
    }

}

