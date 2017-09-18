package persistence;

import model.*;

public class DebitFacade{



	public DebitFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentDebit newDebit(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentDebit)PersistentProxi.createProxi(idCreateIfLessZero, 116);
        long id = ConnectionHandler.getTheConnectionHandler().theEntryFacade.getNextId();
        Debit result = new Debit(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentDebit)PersistentProxi.createProxi(id, 116);
    }
    
    public PersistentDebit newDelayedDebit() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theEntryFacade.getNextId();
        Debit result = new Debit(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentDebit)PersistentProxi.createProxi(id, 116);
    }
    
    public Debit getDebit(long DebitId) throws PersistenceException{
        return null; //All data is in the cache!
    }

}

