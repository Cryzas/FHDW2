package persistence;



public abstract class ComponentICProxi extends PersistentInCacheProxiOptimistic implements PersistentComponent{
    
    public ComponentICProxi(long objectId) {
        super(objectId);
    }
    public ComponentICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentComponent)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentComponent)this.getTheObject()).setName(newValue);
    }
    public abstract PersistentComponent getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentComponent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public boolean contains(final Component4Public component) 
				throws PersistenceException{
        return ((PersistentComponent)this.getTheObject()).contains(component);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentComponent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public ComponentLst4Public fetchMaterials() 
				throws PersistenceException{
        return ((PersistentComponent)this.getTheObject()).fetchMaterials();
    }
    public common.Fraction fetchOverallPrice() 
				throws PersistenceException{
        return ((PersistentComponent)this.getTheObject()).fetchOverallPrice();
    }
    public common.Fraction getOverAllPrice() 
				throws PersistenceException{
        return ((PersistentComponent)this.getTheObject()).getOverAllPrice();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentComponent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentComponent)this.getTheObject()).initializeOnInstantiation();
    }

    
}
