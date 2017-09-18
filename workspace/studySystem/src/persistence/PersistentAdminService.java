package persistence;


public interface PersistentAdminService extends PersistentService, AdminService4Public {
    
    public void setServices(AdminServiceServices4Public newValue) throws PersistenceException ;
    public PersistentAdminService getThis() throws PersistenceException ;
    
    
    public void services_update(final model.meta.subAdminServiceMssgs event) 
				throws PersistenceException;

}

