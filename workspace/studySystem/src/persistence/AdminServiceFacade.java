package persistence;

import model.*;

public class AdminServiceFacade{



	public AdminServiceFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentAdminService newAdminService(long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentAdminService)PersistentProxi.createProxi(idCreateIfLessZero, -289);
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        AdminService result = new AdminService(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAdminService)PersistentProxi.createProxi(id, -289);
    }
    
    public PersistentAdminService newDelayedAdminService() throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getNextId();
        AdminService result = new AdminService(null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentAdminService)PersistentProxi.createProxi(id, -289);
    }
    
    public AdminService getAdminService(long AdminServiceId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public void servicesSet(long AdminServiceId, AdminServiceServices4Public servicesVal) throws PersistenceException {
        
    }

}

