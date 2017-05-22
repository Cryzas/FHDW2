package persistence;



public abstract class BookableICProxi extends PersistentInCacheProxiOptimistic implements PersistentBookable{
    
    public BookableICProxi(long objectId) {
        super(objectId);
    }
    public BookableICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public String getSubject() throws PersistenceException {
        return ((PersistentBookable)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws PersistenceException {
        ((PersistentBookable)this.getTheObject()).setSubject(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentBookable)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentBookable)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentBookable getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBookable)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBookable)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBookable)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBookable)this.getTheObject()).updateObservers(event);
    }
    public void book() 
				throws PersistenceException{
        ((PersistentBookable)this.getTheObject()).book();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBookable)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBookable)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBookable)this.getTheObject()).initializeOnInstantiation();
    }

    
}
