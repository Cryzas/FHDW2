package persistence;



public class AbstractTransferFacade{

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

	

	public AbstractTransferFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 121)) return 121;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void subjectSet(long AbstractTransferId, String subjectVal) throws PersistenceException {
        
    }
    public void stateSet(long AbstractTransferId, TransferState4Public stateVal) throws PersistenceException {
        
    }
    public void subServiceSet(long AbstractTransferId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long AbstractTransferId, AbstractTransfer4Public ThisVal) throws PersistenceException {
        
    }

}

