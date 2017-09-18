package persistence;



public abstract class ModuleAbstractSGroupICProxi extends PersistentInCacheProxiOptimistic implements PersistentModuleAbstractSGroup{
    
    public ModuleAbstractSGroupICProxi(long objectId) {
        super(objectId);
    }
    public ModuleAbstractSGroupICProxi(PersistentObject object) {
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
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentModuleAbstractSGroup)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentModuleAbstractSGroup)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentModuleAbstractSGroup getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentModuleAbstractSGroup)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleAbstractSGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentModuleAbstractSGroup)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentModuleAbstractSGroup)this.getTheObject()).updateObservers(event);
    }
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleAbstractSGroup)this.getTheObject()).containsprogramHierarchySGroup(part);
    }
    public ModuleAbstractStudent4Public copyForStudent() 
				throws PersistenceException{
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
