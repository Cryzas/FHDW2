package persistence;



public abstract class ModuleAbstractICProxi extends PersistentInCacheProxiOptimistic implements PersistentModuleAbstract{
    
    public ModuleAbstractICProxi(long objectId) {
        super(objectId);
    }
    public ModuleAbstractICProxi(PersistentObject object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentModuleAbstract)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentModuleAbstract)this.getTheObject()).setName(newValue);
    }
    public abstract PersistentModuleAbstract getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleAbstract)this.getTheObject()).initialize(This, final$$Fields);
    }
    public boolean containsprogramHierarchy(final programHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleAbstract)this.getTheObject()).containsprogramHierarchy(part);
    }
    public ModuleAbstractSGroup4Public copyForStudyGroup() 
				throws model.UserException, PersistenceException{
        return ((PersistentModuleAbstract)this.getTheObject()).copyForStudyGroup();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleAbstract)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleAbstract)this.getTheObject()).getCreditPoints();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleAbstract)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleAbstract)this.getTheObject()).initializeOnInstantiation();
    }
    public <T> T strategyprogramHierarchy(final programHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleAbstract)this.getTheObject()).strategyprogramHierarchy(strategy);
    }

    
}
