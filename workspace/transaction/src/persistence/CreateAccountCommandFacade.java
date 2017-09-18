package persistence;

import model.meta.*;

public class CreateAccountCommandFacade{

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

	

	public CreateAccountCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCreateAccountCommand newCreateAccountCommand(String name,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentCreateAccountCommand)PersistentProxi.createProxi(idCreateIfLessZero, 123);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAccountCommandFacade.getNextId();
        CreateAccountCommand result = new CreateAccountCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCreateAccountCommand)PersistentProxi.createProxi(id, 123);
    }
    
    public PersistentCreateAccountCommand newDelayedCreateAccountCommand(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateAccountCommandFacade.getNextId();
        CreateAccountCommand result = new CreateAccountCommand(name,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCreateAccountCommand)PersistentProxi.createProxi(id, 123);
    }
    
    public CreateAccountCommand getCreateAccountCommand(long CreateAccountCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 123)) return 123;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void nameSet(long CreateAccountCommandId, String nameVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateAccountCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateAccountCommandId, AccountManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateAccountCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

