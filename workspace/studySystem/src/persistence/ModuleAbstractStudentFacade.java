package persistence;



public class ModuleAbstractStudentFacade{

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

	

	public ModuleAbstractStudentFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 191)) return 191;
        if(Cache.getTheCache().contains(objectId, 193)) return 193;
        if(Cache.getTheCache().contains(objectId, 194)) return 194;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void moduleCopySet(long ModuleAbstractStudentId, ModuleAbstractSGroup4Public moduleCopyVal) throws PersistenceException {
        
    }
    public void subServiceSet(long ModuleAbstractStudentId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long ModuleAbstractStudentId, ModuleAbstractStudent4Public ThisVal) throws PersistenceException {
        
    }

}

