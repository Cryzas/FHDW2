package persistence;

import model.*;

public class ModuleGroupStudentFacade{



	public ModuleGroupStudentFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleGroupStudent newModuleGroupStudent(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentModuleGroupStudent)PersistentProxi.createProxi(idCreateIfLessZero, 194);
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractStudentFacade.getNextId();
        ModuleGroupStudent result = new ModuleGroupStudent(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleGroupStudent)PersistentProxi.createProxi(id, 194);
    }
    
    public PersistentModuleGroupStudent newDelayedModuleGroupStudent() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractStudentFacade.getNextId();
        ModuleGroupStudent result = new ModuleGroupStudent(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleGroupStudent)PersistentProxi.createProxi(id, 194);
    }
    
    public ModuleGroupStudent getModuleGroupStudent(long ModuleGroupStudentId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long modulesAdd(long ModuleGroupStudentId, ModuleAbstractStudent4Public modulesVal) throws PersistenceException {
        return 0;
    }
    public void modulesRem(long modulesId) throws PersistenceException {
        
    }
    public ModuleAbstractStudentList modulesGet(long ModuleGroupStudentId) throws PersistenceException {
        return new ModuleAbstractStudentList(); // remote access for initialization only!
    }

}

