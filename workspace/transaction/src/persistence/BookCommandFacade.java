package persistence;

import model.meta.*;

public class BookCommandFacade{

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

	

	public BookCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentBookCommand newBookCommand(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentBookCommand)PersistentProxi.createProxi(idCreateIfLessZero, 129);
        long id = ConnectionHandler.getTheConnectionHandler().theBookCommandFacade.getNextId();
        BookCommand result = new BookCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentBookCommand)PersistentProxi.createProxi(id, 129);
    }
    
    public PersistentBookCommand newDelayedBookCommand() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theBookCommandFacade.getNextId();
        BookCommand result = new BookCommand(null,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentBookCommand)PersistentProxi.createProxi(id, 129);
    }
    
    public BookCommand getBookCommand(long BookCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 129)) return 129;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void tranferSet(long BookCommandId, AbstractTransfer4Public tranferVal) throws PersistenceException {
        
    }
    public void invokerSet(long BookCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long BookCommandId, TransferManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long BookCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

