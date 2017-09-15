package persistence;

import model.*;

public class ModuleManagerFacade{

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

	

	public ModuleManagerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentModuleManager newModuleManager(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentModuleManager)PersistentProxi.createProxi(idCreateIfLessZero, 145);
        long id = ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade.getNextId();
        ModuleManager result = new ModuleManager(null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleManager)PersistentProxi.createProxi(id, 145);
    }
    
    public PersistentModuleManager newDelayedModuleManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade.getNextId();
        ModuleManager result = new ModuleManager(null,id);
        Cache.getTheCache().put(result);
        return (PersistentModuleManager)PersistentProxi.createProxi(id, 145);
    }
    
    public ModuleManager getModuleManager(long ModuleManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 145)) return 145;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long modulesAdd(long ModuleManagerId, ModuleAbstract4Public modulesVal) throws PersistenceException {
        return 0;
    }
    public void modulesRem(long modulesId) throws PersistenceException {
        
    }
    public ModuleAbstractList modulesGet(long ModuleManagerId) throws PersistenceException {
        return new ModuleAbstractList(); // remote access for initialization only!
    }
    public void ThisSet(long ModuleManagerId, ModuleManager4Public ThisVal) throws PersistenceException {
        
    }

}

