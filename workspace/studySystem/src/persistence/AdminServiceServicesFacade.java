package persistence;

import model.*;

public class AdminServiceServicesFacade{

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

	

	public AdminServiceServicesFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAdminServiceServices newAdminServiceServices(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentAdminServiceServices)PersistentProxi.createProxi(idCreateIfLessZero, 298);
        long id = ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade.getNextId();
        AdminServiceServices result = new AdminServiceServices(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAdminServiceServices)PersistentProxi.createProxi(id, 298);
    }
    
    public PersistentAdminServiceServices newDelayedAdminServiceServices() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade.getNextId();
        AdminServiceServices result = new AdminServiceServices(null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAdminServiceServices)PersistentProxi.createProxi(id, 298);
    }
    
    public AdminServiceServices getAdminServiceServices(long AdminServiceServicesId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 298)) return 298;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void observerSet(long AdminServiceServicesId, AdminService4Public observerVal) throws PersistenceException {
        
    }
    public long observeeAdd(long AdminServiceServicesId, subAdminService4Public observeeVal) throws PersistenceException {
        return 0;
    }
    public void observeeRem(long observeeId) throws PersistenceException {
        
    }
    public subAdminServiceList observeeGet(long AdminServiceServicesId) throws PersistenceException {
        return new subAdminServiceList(); // remote access for initialization only!
    }
    public void ThisSet(long AdminServiceServicesId, AdminServiceServices4Public ThisVal) throws PersistenceException {
        
    }

}

