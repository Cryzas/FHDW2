package persistence;



import model.visitor.*;

public class ModuleWithUnitsSGroupProxi extends ModuleAbstractSGroupProxi implements PersistentModuleWithUnitsSGroup{
    
    public ModuleWithUnitsSGroupProxi(long objectId) {
        super(objectId);
    }
    public ModuleWithUnitsSGroupProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 182;
    }
    
    public ModuleWithUnitsSGroup_UnitsProxi getUnits() throws PersistenceException {
        return ((PersistentModuleWithUnitsSGroup)this.getTheObject()).getUnits();
    }
    public PersistentModuleWithUnitsSGroup getThis() throws PersistenceException {
        return ((PersistentModuleWithUnitsSGroup)this.getTheObject()).getThis();
    }
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsSGroup)this.getTheObject()).containsprogramHierarchySGroup(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleWithUnitsSGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsSGroup)this.getTheObject()).strategyprogramHierarchySGroup(strategy);
    }
    public void addUnit(final UnitSGroup4Public unit) 
				throws model.CycleException, PersistenceException{
        ((PersistentModuleWithUnitsSGroup)this.getTheObject()).addUnit(unit);
    }
    public ModuleAbstractStudent4Public copyForStudent() 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsSGroup)this.getTheObject()).copyForStudent();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleWithUnitsSGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void endModule() 
				throws PersistenceException{
        ((PersistentModuleWithUnitsSGroup)this.getTheObject()).endModule();
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsSGroup)this.getTheObject()).getCreditPoints();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsSGroup)this.getTheObject()).getName();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleWithUnitsSGroup)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleWithUnitsSGroup)this.getTheObject()).initializeOnInstantiation();
    }
    public void swapCP(final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws model.UnitSwapException, PersistenceException{
        ((PersistentModuleWithUnitsSGroup)this.getTheObject()).swapCP(fromUnit, ToUnit, creditPoints);
    }

    
}
