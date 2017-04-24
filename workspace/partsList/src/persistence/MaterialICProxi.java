package persistence;



import model.visitor.*;

public class MaterialICProxi extends ComponentICProxi implements PersistentMaterial{
    
    public MaterialICProxi(long objectId) {
        super(objectId);
    }
    public MaterialICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMaterialFacade
            .getMaterial(this.getId());
    }
    
    public long getClassId() {
        return 116;
    }
    
    public PersistentMaterial getThis() throws PersistenceException {
        return ((PersistentMaterial)this.getTheObject()).getThis();
    }
    
    public void accept(ComponentVisitor visitor) throws PersistenceException {
        visitor.handleMaterial(this);
    }
    public <R> R accept(ComponentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMaterial(this);
    }
    public <E extends model.UserException>  void accept(ComponentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMaterial(this);
    }
    public <R, E extends model.UserException> R accept(ComponentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMaterial(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMaterial(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMaterial(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMaterial(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMaterial(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMaterial)this.getTheObject()).initialize(This, final$$Fields);
    }
    public boolean contains(final Component4Public component) 
				throws PersistenceException{
        return ((PersistentMaterial)this.getTheObject()).contains(component);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMaterial)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public ComponentLst4Public fetchMaterials() 
				throws PersistenceException{
        return ((PersistentMaterial)this.getTheObject()).fetchMaterials();
    }
    public common.Fraction fetchOverallPrice() 
				throws PersistenceException{
        return ((PersistentMaterial)this.getTheObject()).fetchOverallPrice();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMaterial)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMaterial)this.getTheObject()).initializeOnInstantiation();
    }

    
}
