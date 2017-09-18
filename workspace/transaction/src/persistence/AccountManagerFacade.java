package persistence;

import model.*;

public class AccountManagerFacade{

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

	

	public AccountManagerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAccountManager newAccountManager(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentAccountManager)PersistentProxi.createProxi(idCreateIfLessZero, 122);
        long id = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.getNextId();
        AccountManager result = new AccountManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAccountManager)PersistentProxi.createProxi(id, 122);
    }
    
    public PersistentAccountManager newDelayedAccountManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.getNextId();
        AccountManager result = new AccountManager(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAccountManager)PersistentProxi.createProxi(id, 122);
    }
    
    public AccountManager getAccountManager(long AccountManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 122)) return 122;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void currentAccountsSet(long AccountManagerId, AccountManagerCurrentAccounts4Public currentAccountsVal) throws PersistenceException {
        
    }
    public void subServiceSet(long AccountManagerId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long AccountManagerId, AccountManager4Public ThisVal) throws PersistenceException {
        
    }

}

