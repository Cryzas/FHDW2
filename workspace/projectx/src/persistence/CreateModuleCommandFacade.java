package persistence;

import model.meta.*;

public class CreateModuleCommandFacade{

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

	

	public CreateModuleCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCreateModuleCommand newCreateModuleCommand(String type,String name,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentCreateModuleCommand)PersistentProxi.createProxi(idCreateIfLessZero, 159);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateModuleCommandFacade.getNextId();
        CreateModuleCommand result = new CreateModuleCommand(type,name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCreateModuleCommand)PersistentProxi.createProxi(id, 159);
    }
    
    public PersistentCreateModuleCommand newDelayedCreateModuleCommand(String type,String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateModuleCommandFacade.getNextId();
        CreateModuleCommand result = new CreateModuleCommand(type,name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCreateModuleCommand)PersistentProxi.createProxi(id, 159);
    }
    
    public CreateModuleCommand getCreateModuleCommand(long CreateModuleCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 159)) return 159;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void typeSet(long CreateModuleCommandId, String typeVal) throws PersistenceException {
        
    }
    public void nameSet(long CreateModuleCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateModuleCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateModuleCommandId, ModuleManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateModuleCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

