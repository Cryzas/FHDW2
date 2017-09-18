package persistence;

import model.*;

public class ModuleGroupFacade{



	public ModuleGroupFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleGroup newModuleGroup(String name,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentModuleGroup)PersistentProxi.createProxi(idCreateIfLessZero, 166);
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.getNextId();
        ModuleGroup result = new ModuleGroup(name,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleGroup)PersistentProxi.createProxi(id, 166);
    }
    
    public PersistentModuleGroup newDelayedModuleGroup(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.getNextId();
        ModuleGroup result = new ModuleGroup(name,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleGroup)PersistentProxi.createProxi(id, 166);
    }
    
    public ModuleGroup getModuleGroup(long ModuleGroupId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long modulesAdd(long ModuleGroupId, ModuleAbstract4Public modulesVal) throws PersistenceException {
        return 0;
    }
    public void modulesRem(long modulesId) throws PersistenceException {
        
    }
    public ModuleAbstractList modulesGet(long ModuleGroupId) throws PersistenceException {
        return new ModuleAbstractList(); // remote access for initialization only!
    }

}

