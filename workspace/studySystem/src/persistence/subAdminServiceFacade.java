package persistence;



public class subAdminServiceFacade{

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

	

	public subAdminServiceFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, -303)) return -303;
        if(Cache.getTheCache().contains(objectId, -290)) return -290;
        if(Cache.getTheCache().contains(objectId, -305)) return -305;
        if(Cache.getTheCache().contains(objectId, -302)) return -302;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void parentServiceSet(long subAdminServiceId, AdminService4Public parentServiceVal) throws PersistenceException {
        
    }
    public void subServiceSet(long subAdminServiceId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long subAdminServiceId, subAdminService4Public ThisVal) throws PersistenceException {
        
    }

}

