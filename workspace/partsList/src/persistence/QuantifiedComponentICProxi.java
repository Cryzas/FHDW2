package persistence;



import model.visitor.*;

public class QuantifiedComponentICProxi extends PersistentInCacheProxiOptimistic implements PersistentQuantifiedComponent{
    
    public QuantifiedComponentICProxi(long objectId) {
        super(objectId);
    }
    public QuantifiedComponentICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theQuantifiedComponentFacade
            .getQuantifiedComponent(this.getId());
    }
    
    public long getClassId() {
        return 114;
    }
    
    public long getQuantity() throws PersistenceException {
        return ((PersistentQuantifiedComponent)this.getTheObject()).getQuantity();
    }
    public void setQuantity(long newValue) throws PersistenceException {
        ((PersistentQuantifiedComponent)this.getTheObject()).setQuantity(newValue);
    }
    public Component4Public getComponent() throws PersistenceException {
        return ((PersistentQuantifiedComponent)this.getTheObject()).getComponent();
    }
    public void setComponent(Component4Public newValue) throws PersistenceException {
        ((PersistentQuantifiedComponent)this.getTheObject()).setComponent(newValue);
    }
    public PersistentQuantifiedComponent getThis() throws PersistenceException {
        return ((PersistentQuantifiedComponent)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleQuantifiedComponent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleQuantifiedComponent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleQuantifiedComponent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleQuantifiedComponent(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentQuantifiedComponent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addQuantity(final long quantity) 
				throws PersistenceException{
        ((PersistentQuantifiedComponent)this.getTheObject()).addQuantity(quantity);
    }
    public boolean contains(final Component4Public component) 
				throws PersistenceException{
        return ((PersistentQuantifiedComponent)this.getTheObject()).contains(component);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentQuantifiedComponent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public ComponentLst4Public fetchMaterials() 
				throws PersistenceException{
        return ((PersistentQuantifiedComponent)this.getTheObject()).fetchMaterials();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentQuantifiedComponent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentQuantifiedComponent)this.getTheObject()).initializeOnInstantiation();
    }
    public QuantifiedComponent4Public multiply(final long factor) 
				throws PersistenceException{
        return ((PersistentQuantifiedComponent)this.getTheObject()).multiply(factor);
    }

    
}
