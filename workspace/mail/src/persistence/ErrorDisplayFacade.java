package persistence;

import model.*;

public class ErrorDisplayFacade{

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

	

	public ErrorDisplayFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentErrorDisplay newErrorDisplay(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentErrorDisplay)PersistentProxi.createProxi(idCreateIfLessZero, -120);
        long id = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade.getNextId();
        ErrorDisplay result = new ErrorDisplay(id);
        Cache.getTheCache().put(result);
        return (PersistentErrorDisplay)PersistentProxi.createProxi(id, -120);
    }
    
    public PersistentErrorDisplay newDelayedErrorDisplay() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade.getNextId();
        ErrorDisplay result = new ErrorDisplay(id);
        Cache.getTheCache().put(result);
        return (PersistentErrorDisplay)PersistentProxi.createProxi(id, -120);
    }
    
    public ErrorDisplay getErrorDisplay(long ErrorDisplayId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, -120)) return -120;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }

}

