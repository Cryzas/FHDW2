package persistence;



public abstract class ServiceProxi extends PersistentProxi implements PersistentService{
    
    public ServiceProxi(long objectId) {
        super(objectId);
    }
    public ServiceProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public Service_ErrorsProxi getErrors() throws PersistenceException {
        return ((PersistentService)this.getTheObject()).getErrors();
    }
    public abstract PersistentService getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).signalChanged(signal);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentService)this.getTheObject()).initializeOnInstantiation();
    }

    
}
