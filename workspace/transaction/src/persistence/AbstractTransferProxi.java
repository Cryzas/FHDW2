package persistence;



public abstract class AbstractTransferProxi extends PersistentProxi implements PersistentAbstractTransfer{
    
    public AbstractTransferProxi(long objectId) {
        super(objectId);
    }
    public AbstractTransferProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public String getSubject() throws PersistenceException {
        return ((PersistentAbstractTransfer)this.getTheObject()).getSubject();
    }
    public void setSubject(String newValue) throws PersistenceException {
        ((PersistentAbstractTransfer)this.getTheObject()).setSubject(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentAbstractTransfer)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentAbstractTransfer)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentAbstractTransfer getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAbstractTransfer)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAbstractTransfer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAbstractTransfer)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAbstractTransfer)this.getTheObject()).updateObservers(event);
    }
    public void book() 
				throws PersistenceException{
        ((PersistentAbstractTransfer)this.getTheObject()).book();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAbstractTransfer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAbstractTransfer)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAbstractTransfer)this.getTheObject()).initializeOnInstantiation();
    }

    
}
