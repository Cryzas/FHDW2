package persistence;

import model.*;

public class ModuleGroupSGroupFacade{



	public ModuleGroupSGroupFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleGroupSGroup newModuleGroupSGroup(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentModuleGroupSGroup)PersistentProxi.createProxi(idCreateIfLessZero, 178);
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.getNextId();
        ModuleGroupSGroup result = new ModuleGroupSGroup(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleGroupSGroup)PersistentProxi.createProxi(id, 178);
    }
    
    public PersistentModuleGroupSGroup newDelayedModuleGroupSGroup() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.getNextId();
        ModuleGroupSGroup result = new ModuleGroupSGroup(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleGroupSGroup)PersistentProxi.createProxi(id, 178);
    }
    
    public ModuleGroupSGroup getModuleGroupSGroup(long ModuleGroupSGroupId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long modulesAdd(long ModuleGroupSGroupId, ModuleAbstractSGroup4Public modulesVal) throws PersistenceException {
        return 0;
    }
    public void modulesRem(long modulesId) throws PersistenceException {
        
    }
    public ModuleAbstractSGroupList modulesGet(long ModuleGroupSGroupId) throws PersistenceException {
        return new ModuleAbstractSGroupList(); // remote access for initialization only!
    }

}

