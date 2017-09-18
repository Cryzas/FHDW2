package persistence;

import model.*;

public class AccountWrpprAccountFacade{

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

	

	public AccountWrpprAccountFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAccountWrpprAccount newAccountWrpprAccount(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentAccountWrpprAccount)PersistentProxi.createProxi(idCreateIfLessZero, 134);
        long id = ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade.getNextId();
        AccountWrpprAccount result = new AccountWrpprAccount(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAccountWrpprAccount)PersistentProxi.createProxi(id, 134);
    }
    
    public PersistentAccountWrpprAccount newDelayedAccountWrpprAccount() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade.getNextId();
        AccountWrpprAccount result = new AccountWrpprAccount(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAccountWrpprAccount)PersistentProxi.createProxi(id, 134);
    }
    
    public AccountWrpprAccount getAccountWrpprAccount(long AccountWrpprAccountId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 134)) return 134;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void observerSet(long AccountWrpprAccountId, AccountWrppr4Public observerVal) throws PersistenceException {
        
    }
    public void observeeSet(long AccountWrpprAccountId, Account4Public observeeVal) throws PersistenceException {
        
    }
    public void ThisSet(long AccountWrpprAccountId, AccountWrpprAccount4Public ThisVal) throws PersistenceException {
        
    }

}

