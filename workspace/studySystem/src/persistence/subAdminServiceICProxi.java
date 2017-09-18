package persistence;



public abstract class subAdminServiceICProxi extends PersistentInCacheProxiOptimistic implements PersistentsubAdminService{
    
    public subAdminServiceICProxi(long objectId) {
        super(objectId);
    }
    public subAdminServiceICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public AdminService4Public getParentService() throws PersistenceException {
        return ((PersistentsubAdminService)this.getTheObject()).getParentService();
    }
    public void setParentService(AdminService4Public newValue) throws PersistenceException {
        ((PersistentsubAdminService)this.getTheObject()).setParentService(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentsubAdminService)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentsubAdminService)this.getTheObject()).setSubService(newValue);
    }
    public subAdminService_ErrorsProxi getErrors() throws PersistenceException {
        return ((PersistentsubAdminService)this.getTheObject()).getErrors();
    }
    public abstract PersistentsubAdminService getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).register(observee);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).signalChanged(signal);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).updateObservers(event);
    }
    public void updatePLZ() 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).updatePLZ();
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentsubAdminService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).removeError(error);
    }
    public void updateMe() 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).updateMe();
    }
    public void updatePLZImplementation() 
				throws PersistenceException{
        ((PersistentsubAdminService)this.getTheObject()).updatePLZImplementation();
    }

    
}
