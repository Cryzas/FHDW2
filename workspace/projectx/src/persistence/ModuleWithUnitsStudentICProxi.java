package persistence;



import model.visitor.*;

public class ModuleWithUnitsStudentICProxi extends ModuleAbstractStudentICProxi implements PersistentModuleWithUnitsStudent{
    
    public ModuleWithUnitsStudentICProxi(long objectId) {
        super(objectId);
    }
    public ModuleWithUnitsStudentICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsStudentFacade
            .getModuleWithUnitsStudent(this.getId());
    }
    
    public long getClassId() {
        return 193;
    }
    
    public ModuleWithUnitsStudent_UnitsProxi getUnits() throws PersistenceException {
        return ((PersistentModuleWithUnitsStudent)this.getTheObject()).getUnits();
    }
    public PersistentModuleWithUnitsStudent getThis() throws PersistenceException {
        return ((PersistentModuleWithUnitsStudent)this.getTheObject()).getThis();
    }
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsStudent(this);
    }
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsStudent(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsStudent)this.getTheObject()).containsprogramHierarchyStudent(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleWithUnitsStudent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsStudent)this.getTheObject()).strategyprogramHierarchyStudent(strategy);
    }
    public void addUnit(final UnitStudent4Public unit) 
				throws model.CycleException, PersistenceException{
        ((PersistentModuleWithUnitsStudent)this.getTheObject()).addUnit(unit);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleWithUnitsStudent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCPmulGrade() 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsStudent)this.getTheObject()).getCPmulGrade();
    }
    public common.Fraction getCPwithGrade() 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsStudent)this.getTheObject()).getCPwithGrade();
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsStudent)this.getTheObject()).getCreditPoints();
    }
    public MyBoolean4Public getFinished() 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsStudent)this.getTheObject()).getFinished();
    }
    public Grade4Public getGrade() 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsStudent)this.getTheObject()).getGrade();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentModuleWithUnitsStudent)this.getTheObject()).getName();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleWithUnitsStudent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleWithUnitsStudent)this.getTheObject()).initializeOnInstantiation();
    }

    
}
