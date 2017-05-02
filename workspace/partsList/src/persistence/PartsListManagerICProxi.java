package persistence;



import model.visitor.*;

public class PartsListManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentPartsListManager{
    
    public PartsListManagerICProxi(long objectId) {
        super(objectId);
    }
    public PartsListManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().thePartsListManagerFacade
            .getPartsListManager(this.getId());
    }
    
    public long getClassId() {
        return 124;
    }
    
    public PartsListManager_CurrentComponentsProxi getCurrentComponents() throws PersistenceException {
        return ((PersistentPartsListManager)this.getTheObject()).getCurrentComponents();
    }
    public PersistentPartsListManager getThis() throws PersistenceException {
        return ((PersistentPartsListManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePartsListManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePartsListManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePartsListManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePartsListManager(this);
    }
    
    
    public void createMaterial(final String name, final common.Fraction price, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).createMaterial(name, price, invoker);
    }
    public void createProduct(final String name, final common.Fraction price, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).createProduct(name, price, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void clearComponents() 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).clearComponents();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createMaterial(final String name, final common.Fraction price) 
				throws model.PartsListException, PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).createMaterial(name, price);
    }
    public void createProduct(final String name, final common.Fraction price) 
				throws model.PartsListException, PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).createProduct(name, price);
    }
    public void findComponents(final String name) 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).findComponents(name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentPartsListManager)this.getTheObject()).initializeOnInstantiation();
    }

    
}
