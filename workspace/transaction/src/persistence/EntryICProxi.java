package persistence;



public abstract class EntryICProxi extends PersistentInCacheProxiOptimistic implements PersistentEntry{
    
    public EntryICProxi(long objectId) {
        super(objectId);
    }
    public EntryICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public Transfer4Public getTransfer() throws PersistenceException {
        return ((PersistentEntry)this.getTheObject()).getTransfer();
    }
    public void setTransfer(Transfer4Public newValue) throws PersistenceException {
        ((PersistentEntry)this.getTheObject()).setTransfer(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentEntry)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentEntry)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentEntry getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentEntry)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentEntry)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentEntry)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentEntry)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentEntry)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentEntry)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentEntry)this.getTheObject()).initializeOnInstantiation();
    }

    
}
