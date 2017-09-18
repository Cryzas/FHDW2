package persistence;

import model.meta.*;

public class CreateTransferCommandFacade{

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

	

	public CreateTransferCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentCreateTransferCommand newCreateTransferCommand(common.Fraction amount,String subject,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentCreateTransferCommand)PersistentProxi.createProxi(idCreateIfLessZero, 126);
        long id = ConnectionHandler.getTheConnectionHandler().theCreateTransferCommandFacade.getNextId();
        CreateTransferCommand result = new CreateTransferCommand(null,null,amount,subject,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCreateTransferCommand)PersistentProxi.createProxi(id, 126);
    }
    
    public PersistentCreateTransferCommand newDelayedCreateTransferCommand(common.Fraction amount,String subject) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theCreateTransferCommandFacade.getNextId();
        CreateTransferCommand result = new CreateTransferCommand(null,null,amount,subject,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentCreateTransferCommand)PersistentProxi.createProxi(id, 126);
    }
    
    public CreateTransferCommand getCreateTransferCommand(long CreateTransferCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 126)) return 126;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void fromAccountSet(long CreateTransferCommandId, AccountHandle4Public fromAccountVal) throws PersistenceException {
        
    }
    public void toAccountSet(long CreateTransferCommandId, AccountHandle4Public toAccountVal) throws PersistenceException {
        
    }
    public void amountSet(long CreateTransferCommandId, common.Fraction amountVal) throws PersistenceException {
        
    }
    public void subjectSet(long CreateTransferCommandId, String subjectVal) throws PersistenceException {
        
    }
    public void invokerSet(long CreateTransferCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long CreateTransferCommandId, TransferManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long CreateTransferCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

