package persistence;

import model.*;

public class WrapperRecycleFacade{

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

	

	public WrapperRecycleFacade() {
	}

    public PersistentWrapperRecycle getTheWrapperRecycle() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theWrapperRecycleFacade.getNextId();
        WrapperRecycle result = new WrapperRecycle(null, null, id);
        PersistentInCacheProxi cached = Cache.getTheCache().putSingleton(result);
        return (PersistentWrapperRecycle)PersistentProxi.createProxi(cached.getId()  * (cached.getTheObject().isTheSameAs(result) ? -1 : 1), 141);
    }
    
    public WrapperRecycle getWrapperRecycle(long WrapperRecycleId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 141)) return 141;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public long recycledAdd(long WrapperRecycleId, AccountWrppr4Public recycledVal) throws PersistenceException {
        return 0;
    }
    public void recycledRem(long recycledId) throws PersistenceException {
        
    }
    public AccountWrpprList recycledGet(long WrapperRecycleId) throws PersistenceException {
        return new AccountWrpprList(); // remote access for initialization only!
    }
    public void subServiceSet(long WrapperRecycleId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long WrapperRecycleId, WrapperRecycle4Public ThisVal) throws PersistenceException {
        
    }

}

