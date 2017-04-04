package persistence;



import model.visitor.*;

public class ComponentLstProxi extends PersistentProxi implements PersistentComponentLst{
    
    public ComponentLstProxi(long objectId) {
        super(objectId);
    }
    public ComponentLstProxi(PersistentInCacheProxi object) {
        super(object);
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
    public void addPart(final Component4Public component, final long quantity) 
				throws PersistenceException{
        ((PersistentComponentLst)this.getTheObject()).addPart(component, quantity);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentComponentLst)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentComponentLst)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentComponentLst)this.getTheObject()).initializeOnInstantiation();
    }

    
}
