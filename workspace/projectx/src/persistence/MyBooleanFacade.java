package persistence;



public class MyBooleanFacade{

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

	

	public MyBooleanFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 282)) return 282;
        if(Cache.getTheCache().contains(objectId, 281)) return 281;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void ThisSet(long MyBooleanId, MyBoolean4Public ThisVal) throws PersistenceException {
        
    }

}

