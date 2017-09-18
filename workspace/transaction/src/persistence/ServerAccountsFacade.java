package persistence;

import model.*;

public class ServerAccountsFacade{

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

	

	public ServerAccountsFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentServerAccounts newServerAccounts(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentServerAccounts)PersistentProxi.createProxi(idCreateIfLessZero, 136);
        long id = ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade.getNextId();
        ServerAccounts result = new ServerAccounts(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentServerAccounts)PersistentProxi.createProxi(id, 136);
    }
    
    public PersistentServerAccounts newDelayedServerAccounts() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade.getNextId();
        ServerAccounts result = new ServerAccounts(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentServerAccounts)PersistentProxi.createProxi(id, 136);
    }
    
    public ServerAccounts getServerAccounts(long ServerAccountsId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 136)) return 136;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void observerSet(long ServerAccountsId, Server4Public observerVal) throws PersistenceException {
        
    }
    public void observeeSet(long ServerAccountsId, AccountManager4Public observeeVal) throws PersistenceException {
        
    }
    public void ThisSet(long ServerAccountsId, ServerAccounts4Public ThisVal) throws PersistenceException {
        
    }

}

