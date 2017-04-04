package persistence;



import model.visitor.*;

public class ProductICProxi extends ComponentICProxi implements PersistentProduct{
    
    public ProductICProxi(long objectId) {
        super(objectId);
    }
    public ProductICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theProductFacade
            .getProduct(this.getId());
    }
    
    public long getClassId() {
        return 115;
    }
    
    public ComponentLst4Public getComponents() throws PersistenceException {
        return ((PersistentProduct)this.getTheObject()).getComponents();
    }
    public void setComponents(ComponentLst4Public newValue) throws PersistenceException {
        ((PersistentProduct)this.getTheObject()).setComponents(newValue);
    }
    public PersistentProduct getThis() throws PersistenceException {
        return ((PersistentProduct)this.getTheObject()).getThis();
    }
    
    public void accept(ComponentVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends model.UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends model.UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addPart(final Component4Public component, final long quantity) 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).addPart(component, quantity);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentProduct)this.getTheObject()).initializeOnInstantiation();
    }

    
}
