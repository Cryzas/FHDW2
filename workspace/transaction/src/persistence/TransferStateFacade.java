package persistence;



public class TransferStateFacade{

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

	

	public TransferStateFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 138)) return 138;
        if(Cache.getTheCache().contains(objectId, 137)) return 137;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void subServiceSet(long TransferStateId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long TransferStateId, TransferState4Public ThisVal) throws PersistenceException {
        
    }

}

