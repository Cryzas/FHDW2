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
    public ModuleGroupSearchList inverseGetModules(long objectId, long classId)throws PersistenceException{
        ModuleGroupSearchList result = new ModuleGroupSearchList();
        java.util.Iterator<PersistentInCacheProxi> candidates;
        candidates = Cache.getTheCache().iterator(166);
        while (candidates.hasNext()){
            PersistentModuleGroup current = (PersistentModuleGroup)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null){
                java.util.Iterator<ModuleAbstract4Public> iterator = ((ModuleGroup_ModulesProxi)current.getModules()).iterator();
                while(iterator.hasNext()){
                    PersistentProxi item = (PersistentProxi)iterator.next();
                    if (!item.isDltd() && !current.isDelayed$Persistence() && item.getClassId() == classId && item.getId() == objectId) {
                        PersistentModuleGroup proxi = (PersistentModuleGroup)PersistentProxi.createProxi(current.getId(), current.getClassId());
                        result.add((PersistentModuleGroup)proxi.getThis());
                    }
                }
            }
        }
        return result;
    }

}

