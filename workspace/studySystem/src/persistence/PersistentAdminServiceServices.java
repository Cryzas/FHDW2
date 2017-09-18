package persistence;


public interface PersistentAdminServiceServices extends PersistentListProxiInterface<subAdminService4Public>, Anything, ObsInterface, AbstractPersistentProxi, AdminServiceServices4Public {
    
    public AdminService4Public getObserver() throws PersistenceException ;
    public void setObserver(AdminService4Public newValue) throws PersistenceException ;
    public PersistentAdminServiceServices getThis() throws PersistenceException ;
    
    

}

