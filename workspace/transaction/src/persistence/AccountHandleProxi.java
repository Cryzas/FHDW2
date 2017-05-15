package persistence;



public abstract class AccountHandleProxi extends PersistentProxi implements PersistentAccountHandle{
    
    public AccountHandleProxi(long objectId) {
        super(objectId);
    }
    public AccountHandleProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentAccountHandle)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentAccountHandle)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentAccountHandle getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountHandle)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccountHandle)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountHandle)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountHandle)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccountHandle)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public Account4Public fetchAccount() 
				throws PersistenceException{
        return ((PersistentAccountHandle)this.getTheObject()).fetchAccount();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccountHandle)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccountHandle)this.getTheObject()).initializeOnInstantiation();
    }

    
}
