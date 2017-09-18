package persistence;



public class EntryFacade{

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

	

	public EntryFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 116)) return 116;
        if(Cache.getTheCache().contains(objectId, 120)) return 120;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void transferSet(long EntryId, Transfer4Public transferVal) throws PersistenceException {
        
    }
    public void subServiceSet(long EntryId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long EntryId, Entry4Public ThisVal) throws PersistenceException {
        
    }

}

