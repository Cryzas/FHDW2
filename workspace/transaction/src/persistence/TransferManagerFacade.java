package persistence;

import model.*;

public class TransferManagerFacade{

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

	

	public TransferManagerFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentTransferManager newTransferManager(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentTransferManager)PersistentProxi.createProxi(idCreateIfLessZero, 114);
        long id = ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade.getNextId();
        TransferManager result = new TransferManager(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentTransferManager)PersistentProxi.createProxi(id, 114);
    }
    
    public PersistentTransferManager newDelayedTransferManager() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theTransferManagerFacade.getNextId();
        TransferManager result = new TransferManager(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentTransferManager)PersistentProxi.createProxi(id, 114);
    }
    
    public TransferManager getTransferManager(long TransferManagerId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 114)) return 114;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long transfersAdd(long TransferManagerId, AbstractTransfer4Public transfersVal) throws PersistenceException {
        return 0;
    }
    public void transfersRem(long transfersId) throws PersistenceException {
        
    }
    public AbstractTransferList transfersGet(long TransferManagerId) throws PersistenceException {
        return new AbstractTransferList(); // remote access for initialization only!
    }
    public void subServiceSet(long TransferManagerId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long TransferManagerId, TransferManager4Public ThisVal) throws PersistenceException {
        
    }

}

