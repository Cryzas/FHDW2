package persistence;



public class AccountHandleFacade{

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

	

	public AccountHandleFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 140)) return 140;
        if(Cache.getTheCache().contains(objectId, 115)) return 115;
        if(Cache.getTheCache().contains(objectId, 118)) return 118;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void subServiceSet(long AccountHandleId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long AccountHandleId, AccountHandle4Public ThisVal) throws PersistenceException {
        
    }

}

