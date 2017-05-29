package persistence;



public abstract class ContaineeICProxi extends PersistentInCacheProxiOptimistic implements PersistentContainee{
    
    public ContaineeICProxi(long objectId) {
        super(objectId);
    }
    public ContaineeICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentContainee)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentContainee)this.getTheObject()).setName(newValue);
    }
    public abstract PersistentContainee getThis() throws PersistenceException ;
    
    
    
    public void delete(final Invoker invoker) 
				throws PersistenceException{
        ((PersistentContainee)this.getTheObject()).delete(invoker);
    }
    public DirectorySearchList getParent() 
				throws PersistenceException{
        return ((PersistentContainee)this.getTheObject()).getParent();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentContainee)this.getTheObject()).initialize(This, final$$Fields);
    }
    public boolean containsFileTree(final FileTreeHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentContainee)this.getTheObject()).containsFileTree(part);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentContainee)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void delete() 
				throws model.FileSystemException, PersistenceException{
        ((PersistentContainee)this.getTheObject()).delete();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentContainee)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentContainee)this.getTheObject()).initializeOnInstantiation();
    }
    public <T> T strategyFileTree(final FileTreeHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentContainee)this.getTheObject()).strategyFileTree(strategy);
    }

    
}
