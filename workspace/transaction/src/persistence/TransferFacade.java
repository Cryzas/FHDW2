package persistence;

import model.*;

public class TransferFacade{



	public TransferFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentTransfer newTransfer(String subject,common.Fraction amount,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentTransfer)PersistentProxi.createProxi(idCreateIfLessZero, 121);
        long id = ConnectionHandler.getTheConnectionHandler().theAbstractTransferFacade.getNextId();
        Transfer result = new Transfer(subject,null,null,null,null,null,amount,id);
        Cache.getTheCache().put(result);
        return (PersistentTransfer)PersistentProxi.createProxi(id, 121);
    }
    
    public PersistentTransfer newDelayedTransfer(String subject,common.Fraction amount) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAbstractTransferFacade.getNextId();
        Transfer result = new Transfer(subject,null,null,null,null,null,amount,id);
        Cache.getTheCache().put(result);
        return (PersistentTransfer)PersistentProxi.createProxi(id, 121);
    }
    
    public Transfer getTransfer(long TransferId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void fromAccountSet(long TransferId, Account4Public fromAccountVal) throws PersistenceException {
        
    }
    public void toAccountSet(long TransferId, Account4Public toAccountVal) throws PersistenceException {
        
    }
    public void amountSet(long TransferId, common.Fraction amountVal) throws PersistenceException {
        
    }

}

