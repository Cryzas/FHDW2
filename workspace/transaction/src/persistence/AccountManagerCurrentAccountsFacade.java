package persistence;

import model.*;

public class AccountManagerCurrentAccountsFacade{

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

	

	public AccountManagerCurrentAccountsFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAccountManagerCurrentAccounts newAccountManagerCurrentAccounts(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentAccountManagerCurrentAccounts)PersistentProxi.createProxi(idCreateIfLessZero, 135);
        long id = ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade.getNextId();
        AccountManagerCurrentAccounts result = new AccountManagerCurrentAccounts(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAccountManagerCurrentAccounts)PersistentProxi.createProxi(id, 135);
    }
    
    public PersistentAccountManagerCurrentAccounts newDelayedAccountManagerCurrentAccounts() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade.getNextId();
        AccountManagerCurrentAccounts result = new AccountManagerCurrentAccounts(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAccountManagerCurrentAccounts)PersistentProxi.createProxi(id, 135);
    }
    
    public AccountManagerCurrentAccounts getAccountManagerCurrentAccounts(long AccountManagerCurrentAccountsId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 135)) return 135;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void observerSet(long AccountManagerCurrentAccountsId, AccountManager4Public observerVal) throws PersistenceException {
        
    }
    public long observeeAdd(long AccountManagerCurrentAccountsId, AccountHandle4Public observeeVal) throws PersistenceException {
        return 0;
    }
    public void observeeRem(long observeeId) throws PersistenceException {
        
    }
    public AccountHandleList observeeGet(long AccountManagerCurrentAccountsId) throws PersistenceException {
        return new AccountHandleList(); // remote access for initialization only!
    }
    public void ThisSet(long AccountManagerCurrentAccountsId, AccountManagerCurrentAccounts4Public ThisVal) throws PersistenceException {
        
    }

}

