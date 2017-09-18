package persistence;


public interface PersistentsubAdminService extends Invoker, Anything, SubjInterface, Remote, AbstractPersistentProxi, subAdminService4Public {
    
    public void setParentService(AdminService4Public newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public subAdminService_ErrorsProxi getErrors() throws PersistenceException ;
    public abstract PersistentsubAdminService getThis() throws PersistenceException ;
    
    

}

