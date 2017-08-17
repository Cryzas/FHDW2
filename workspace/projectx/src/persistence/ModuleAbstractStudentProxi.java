package persistence;



public abstract class ModuleAbstractStudentProxi extends PersistentProxi implements PersistentModuleAbstractStudent{
    
    public ModuleAbstractStudentProxi(long objectId) {
        super(objectId);
    }
    public ModuleAbstractStudentProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public ModuleAbstractSGroup4Public getModuleCopy() throws PersistenceException {
        return ((PersistentModuleAbstractStudent)this.getTheObject()).getModuleCopy();
    }
    public void setModuleCopy(ModuleAbstractSGroup4Public newValue) throws PersistenceException {
        ((PersistentModuleAbstractStudent)this.getTheObject()).setModuleCopy(newValue);
    }
    public abstract PersistentModuleAbstractStudent getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleAbstractStudent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleAbstractStudent)this.getTheObject()).containsprogramHierarchyStudent(part);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleAbstractStudent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleAbstractStudent)this.getTheObject()).getCreditPoints();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentModuleAbstractStudent)this.getTheObject()).getName();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleAbstractStudent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleAbstractStudent)this.getTheObject()).initializeOnInstantiation();
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleAbstractStudent)this.getTheObject()).strategyprogramHierarchyStudent(strategy);
    }

    
}