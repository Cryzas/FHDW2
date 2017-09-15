package persistence;



import model.visitor.*;

public class ModuleWithUnitsProxi extends ModuleAbstractProxi implements PersistentModuleWithUnits{
    
    public ModuleWithUnitsProxi(long objectId) {
        super(objectId);
    }
    public ModuleWithUnitsProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 154;
    }
    
    public ModuleWithUnits_UnitsProxi getUnits() throws PersistenceException {
        return ((PersistentModuleWithUnits)this.getTheObject()).getUnits();
    }
    public PersistentModuleWithUnits getThis() throws PersistenceException {
        return ((PersistentModuleWithUnits)this.getTheObject()).getThis();
    }
    
    public void accept(ModuleAbstractVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(programHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(programHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    
    
    public boolean containsprogramHierarchy(final programHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleWithUnits)this.getTheObject()).containsprogramHierarchy(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchy(final programHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleWithUnits)this.getTheObject()).strategyprogramHierarchy(strategy);
    }
    public void addUnit(final String name, final common.Fraction creditPoints) 
				throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).addUnit(name, creditPoints);
    }
    public ModuleAbstractSGroup4Public copyForStudyGroup() 
				throws PersistenceException{
        return ((PersistentModuleWithUnits)this.getTheObject()).copyForStudyGroup();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleWithUnits)this.getTheObject()).getCreditPoints();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleWithUnits)this.getTheObject()).initializeOnInstantiation();
    }

    
}
