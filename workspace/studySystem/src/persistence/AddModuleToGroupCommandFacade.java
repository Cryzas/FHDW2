package persistence;

import model.meta.*;

public class AddModuleToGroupCommandFacade{

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

	

	public AddModuleToGroupCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAddModuleToGroupCommand newAddModuleToGroupCommand(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentAddModuleToGroupCommand)PersistentProxi.createProxi(idCreateIfLessZero, 169);
        long id = ConnectionHandler.getTheConnectionHandler().theAddModuleToGroupCommandFacade.getNextId();
        AddModuleToGroupCommand result = new AddModuleToGroupCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAddModuleToGroupCommand)PersistentProxi.createProxi(id, 169);
    }
    
    public PersistentAddModuleToGroupCommand newDelayedAddModuleToGroupCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAddModuleToGroupCommandFacade.getNextId();
        AddModuleToGroupCommand result = new AddModuleToGroupCommand(null,null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAddModuleToGroupCommand)PersistentProxi.createProxi(id, 169);
    }
    
    public AddModuleToGroupCommand getAddModuleToGroupCommand(long AddModuleToGroupCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 169)) return 169;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void groupSet(long AddModuleToGroupCommandId, ModuleGroup4Public groupVal) throws PersistenceException {
        
    }
    public void moduleSet(long AddModuleToGroupCommandId, ModuleAbstract4Public moduleVal) throws PersistenceException {
        
    }
    public void invokerSet(long AddModuleToGroupCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long AddModuleToGroupCommandId, ModuleManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long AddModuleToGroupCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

