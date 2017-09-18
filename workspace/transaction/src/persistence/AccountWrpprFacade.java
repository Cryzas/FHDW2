package persistence;

import model.*;

public class AccountWrpprFacade{



	public AccountWrpprFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAccountWrppr newAccountWrppr(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentAccountWrppr)PersistentProxi.createProxi(idCreateIfLessZero, 118);
        long id = ConnectionHandler.getTheConnectionHandler().theAccountHandleFacade.getNextId();
        AccountWrppr result = new AccountWrppr(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAccountWrppr)PersistentProxi.createProxi(id, 118);
    }
    
    public PersistentAccountWrppr newDelayedAccountWrppr() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAccountHandleFacade.getNextId();
        AccountWrppr result = new AccountWrppr(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAccountWrppr)PersistentProxi.createProxi(id, 118);
    }
    
    public AccountWrppr getAccountWrppr(long AccountWrpprId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void accountSet(long AccountWrpprId, AccountWrpprAccount4Public accountVal) throws PersistenceException {
        
    }

}

