package persistence;



public abstract class ModuleAbstractSGroupProxi extends PersistentProxi implements PersistentModuleAbstractSGroup{
    
    public ModuleAbstractSGroupProxi(long objectId) {
        super(objectId);
    }
    public ModuleAbstractSGroupProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public String getName() throws PersistenceException {
        return ((PersistentModuleAbstractSGroup)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentModuleAbstractSGroup)this.getTheObject()).setName(newValue);
    }
    public abstract PersistentModuleAbstractSGroup getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleAbstractSGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleAbstractSGroup)this.getTheObject()).containsprogramHierarchySGroup(part);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleAbstractSGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleAbstractSGroup)this.getTheObject()).getCreditPoints();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleAbstractSGroup)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleAbstractSGroup)this.getTheObject()).initializeOnInstantiation();
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleAbstractSGroup)this.getTheObject()).strategyprogramHierarchySGroup(strategy);
    }

    
}
