package persistence;



import model.visitor.*;

public class WrapperRecycleICProxi extends PersistentInCacheProxiOptimistic implements PersistentWrapperRecycle{
    
    public WrapperRecycleICProxi(long objectId) {
        super(objectId);
    }
    public WrapperRecycleICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theWrapperRecycleFacade
            .getWrapperRecycle(this.getId());
    }
    
    public long getClassId() {
        return 141;
    }
    
    public WrapperRecycle_RecycledProxi getRecycled() throws PersistenceException {
        return ((PersistentWrapperRecycle)this.getTheObject()).getRecycled();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentWrapperRecycle)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentWrapperRecycle)this.getTheObject()).setSubService(newValue);
    }
    public PersistentWrapperRecycle getThis() throws PersistenceException {
        return ((PersistentWrapperRecycle)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleWrapperRecycle(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWrapperRecycle(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWrapperRecycle(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWrapperRecycle(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleWrapperRecycle(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleWrapperRecycle(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleWrapperRecycle(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleWrapperRecycle(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentWrapperRecycle)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentWrapperRecycle)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentWrapperRecycle)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentWrapperRecycle)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentWrapperRecycle)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public AccountWrppr4Public fecthAccountWrapper(final Account4Public account) 
				throws PersistenceException{
        return ((PersistentWrapperRecycle)this.getTheObject()).fecthAccountWrapper(account);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentWrapperRecycle)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentWrapperRecycle)this.getTheObject()).initializeOnInstantiation();
    }
    public void storeWrapper(final AccountWrppr4Public wrapper) 
				throws PersistenceException{
        ((PersistentWrapperRecycle)this.getTheObject()).storeWrapper(wrapper);
    }

    
}
