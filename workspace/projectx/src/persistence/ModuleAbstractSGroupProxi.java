package persistence;



public abstract class ModuleAbstractSGroupProxi extends PersistentProxi implements PersistentModuleAbstractSGroup{
    
    public ModuleAbstractSGroupProxi(long objectId) {
        super(objectId);
    }
    public ModuleAbstractSGroupProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public ModuleAbstract4Public getModuleCopy() throws PersistenceException {
        return ((PersistentModuleAbstractSGroup)this.getTheObject()).getModuleCopy();
    }
    public void setModuleCopy(ModuleAbstract4Public newValue) throws PersistenceException {
        ((PersistentModuleAbstractSGroup)this.getTheObject()).setModuleCopy(newValue);
    }
    public MyBoolean4Public getFinished() throws PersistenceException {
        return ((PersistentModuleAbstractSGroup)this.getTheObject()).getFinished();
    }
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException {
        ((PersistentModuleAbstractSGroup)this.getTheObject()).setFinished(newValue);
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
    public ModuleAbstractStudent4Public copyForStudent() 
				throws model.UserException, PersistenceException{
        return ((PersistentModuleAbstractSGroup)this.getTheObject()).copyForStudent();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleAbstractSGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void endModule() 
				throws PersistenceException{
        ((PersistentModuleAbstractSGroup)this.getTheObject()).endModule();
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleAbstractSGroup)this.getTheObject()).getCreditPoints();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentModuleAbstractSGroup)this.getTheObject()).getName();
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
