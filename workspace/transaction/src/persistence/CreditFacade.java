package persistence;

import model.*;

public class CreditFacade{



	public CreditFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCredit newCredit(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentCredit)PersistentProxi.createProxi(idCreateIfLessZero, 120);
        long id = ConnectionHandler.getTheConnectionHandler().theEntryFacade.getNextId();
        Credit result = new Credit(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCredit)PersistentProxi.createProxi(id, 120);
    }
    
    public PersistentCredit newDelayedCredit() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theEntryFacade.getNextId();
        Credit result = new Credit(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCredit)PersistentProxi.createProxi(id, 120);
    }
    
    public Credit getCredit(long CreditId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

