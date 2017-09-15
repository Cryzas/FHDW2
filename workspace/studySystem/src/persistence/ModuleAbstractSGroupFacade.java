package persistence;



public class ModuleAbstractSGroupFacade{

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

	

	public ModuleAbstractSGroupFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 178)) return 178;
        if(Cache.getTheCache().contains(objectId, 179)) return 179;
        if(Cache.getTheCache().contains(objectId, 182)) return 182;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void moduleCopySet(long ModuleAbstractSGroupId, ModuleAbstract4Public moduleCopyVal) throws PersistenceException {
        
    }
    public void finishedSet(long ModuleAbstractSGroupId, MyBoolean4Public finishedVal) throws PersistenceException {
        
    }
    public void ThisSet(long ModuleAbstractSGroupId, ModuleAbstractSGroup4Public ThisVal) throws PersistenceException {
        
    }

}

