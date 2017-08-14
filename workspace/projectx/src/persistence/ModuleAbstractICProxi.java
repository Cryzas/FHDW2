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
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentModuleAbstract)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentModuleAbstract)this.getTheObject()).setSubService(newValue);
    }
    public abstract PersistentModuleAbstract getThis() throws PersistenceException ;
    
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentModuleAbstract)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleAbstract)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentModuleAbstract)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentModuleAbstract)this.getTheObject()).updateObservers(event);
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

    
}
