package persistence;



import model.visitor.*;

public class ModuleGroupStudentICProxi extends ModuleAbstractStudentICProxi implements PersistentModuleGroupStudent{
    
    public ModuleGroupStudentICProxi(long objectId) {
        super(objectId);
    }
    public ModuleGroupStudentICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theModuleGroupStudentFacade
            .getModuleGroupStudent(this.getId());
    }
    
    public long getClassId() {
        return 194;
    }
    
    public ModuleGroupStudent_ModulesProxi getModules() throws PersistenceException {
        return ((PersistentModuleGroupStudent)this.getTheObject()).getModules();
    }
    public PersistentModuleGroupStudent getThis() throws PersistenceException {
        return ((PersistentModuleGroupStudent)this.getTheObject()).getThis();
    }
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupStudent(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupStudent(this);
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).containsprogramHierarchyStudent(part);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).register(observee);
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).strategyprogramHierarchyStudent(strategy);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).updateObservers(event);
    }
    public void addModule(final ModuleAbstractStudent4Public module) 
				throws model.CycleException, PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).addModule(module);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCPmulGrade() 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).getCPmulGrade();
    }
    public common.Fraction getCPwithGrade() 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).getCPwithGrade();
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).getCreditPoints();
    }
    public MyBoolean4Public getFinished() 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).getFinished();
    }
    public Grade4Public getGrade() 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).getGrade();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).getName();
    }
    public common.Fraction getPassedCP() 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).getPassedCP();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).initializeOnInstantiation();
    }

    
}
