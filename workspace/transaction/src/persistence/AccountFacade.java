package persistence;

import model.*;

public class AccountFacade{



	public AccountFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAccount newAccount(String name,common.Fraction balance,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentAccount)PersistentProxi.createProxi(idCreateIfLessZero, 115);
        long id = ConnectionHandler.getTheConnectionHandler().theAccountHandleFacade.getNextId();
        Account result = new Account(null,null,name,balance,id);
        Cache.getTheCache().put(result);
        return (PersistentAccount)PersistentProxi.createProxi(id, 115);
    }
    
    public PersistentAccount newDelayedAccount(String name,common.Fraction balance) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAccountHandleFacade.getNextId();
        Account result = new Account(null,null,name,balance,id);
        Cache.getTheCache().put(result);
        return (PersistentAccount)PersistentProxi.createProxi(id, 115);
    }
    
    public Account getAccount(long AccountId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public AccountSearchList getAccountByName(String name) throws PersistenceException {
        name = name.replaceAll("\\\\", "\\\\\\\\");
        name = name.replaceAll("\\?", "\\\\?");
        name = name.replaceAll("\\+", "\\\\+");
        name = name.replaceAll("\\*", "\\\\*");
        name = name.replaceAll("\\[", "\\\\[");
        name = name.replaceAll("\\]", "\\\\]");
        name = name.replaceAll("\\{", "\\\\{");
        name = name.replaceAll("\\}", "\\\\}");
        name = name.replaceAll("\\&", "\\\\&");
        name = name.replaceAll("\\-", "\\\\-");
        name = name.replaceAll("@@", "@-");
        name = name.replaceAll("%", "%-");
        name = name.replaceAll("_", "_-");
        name = name.replaceAll("@_-", "_");
        name = name.replaceAll("@%-", "%");
        name = name.replaceAll("@-", "@");
        name = name.replaceAll("%-", ".*");
        name = name.replaceAll("_-", ".");
        AccountSearchList result = new AccountSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(140);
        while (candidates.hasNext()){
            PersistentAccount current = (PersistentAccount)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getName().matches(name))
                result.add((PersistentAccount)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        candidates = Cache.getTheCache().iterator(115);
        while (candidates.hasNext()){
            PersistentAccount current = (PersistentAccount)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getName().matches(name))
                result.add((PersistentAccount)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long AccountId, String nameVal) throws PersistenceException {
        
    }
    public void balanceSet(long AccountId, common.Fraction balanceVal) throws PersistenceException {
        
    }
    public long entriesAdd(long AccountId, Entry4Public entriesVal) throws PersistenceException {
        return 0;
    }
    public void entriesRem(long entriesId) throws PersistenceException {
        
    }
    public EntryList entriesGet(long AccountId) throws PersistenceException {
        return new EntryList(); // remote access for initialization only!
    }

}

