package persistence;



import model.visitor.*;

public class ComponentLstICProxi extends PersistentInCacheProxiOptimistic implements PersistentComponentLst{
    
    public ComponentLstICProxi(long objectId) {
        super(objectId);
    }
    public ComponentLstICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theComponentLstFacade
            .getComponentLst(this.getId());
    }
    
    public long getClassId() {
        return 117;
    }
    
    public ComponentLst_PartsProxi getParts() throws PersistenceException {
        return ((PersistentComponentLst)this.getTheObject()).getParts();
    }
    public PersistentComponentLst getThis() throws PersistenceException {
        return ((PersistentComponentLst)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleComponentLst(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleComponentLst(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleComponentLst(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleComponentLst(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentComponentLst)this.getTheObject()).initialize(This, final$$Fields);
    }
    public ComponentLst4Public addList(final ComponentLst4Public argument) 
				throws PersistenceException{
        return ((PersistentComponentLst)this.getTheObject()).addList(argument);
    }
    public void addPart(final Component4Public component, final long quantity) 
				throws PersistenceException{
        ((PersistentComponentLst)this.getTheObject()).addPart(component, quantity);
    }
    public boolean contains(final Component4Public component) 
				throws PersistenceException{
        return ((PersistentComponentLst)this.getTheObject()).contains(component);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentComponentLst)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public ComponentLst4Public fetchMaterials() 
				throws PersistenceException{
        return ((PersistentComponentLst)this.getTheObject()).fetchMaterials();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentComponentLst)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentComponentLst)this.getTheObject()).initializeOnInstantiation();
    }
    public ComponentLst4Public multiply(final long factor) 
				throws PersistenceException{
        return ((PersistentComponentLst)this.getTheObject()).multiply(factor);
    }

    
}
