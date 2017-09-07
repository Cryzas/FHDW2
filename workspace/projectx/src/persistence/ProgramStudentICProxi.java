package persistence;



import model.visitor.*;

public class ProgramStudentICProxi extends PersistentInCacheProxiOptimistic implements PersistentProgramStudent{
    
    public ProgramStudentICProxi(long objectId) {
        super(objectId);
    }
    public ProgramStudentICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade
            .getProgramStudent(this.getId());
    }
    
    public long getClassId() {
        return 192;
    }
    
    public ProgramStudent_ModulesProxi getModules() throws PersistenceException {
        return ((PersistentProgramStudent)this.getTheObject()).getModules();
    }
    public ProgramSGroup4Public getProgramCopy() throws PersistenceException {
        return ((PersistentProgramStudent)this.getTheObject()).getProgramCopy();
    }
    public void setProgramCopy(ProgramSGroup4Public newValue) throws PersistenceException {
        ((PersistentProgramStudent)this.getTheObject()).setProgramCopy(newValue);
    }
    public PersistentProgramStudent getThis() throws PersistenceException {
        return ((PersistentProgramStudent)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProgramStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleProgramStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramStudent(this);
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentProgramStudent)this.getTheObject()).containsprogramHierarchyStudent(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentProgramStudent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentProgramStudent)this.getTheObject()).strategyprogramHierarchyStudent(strategy);
    }
    public void addModule(final ModuleAbstractStudent4Public module) 
				throws model.CycleException, PersistenceException{
        ((PersistentProgramStudent)this.getTheObject()).addModule(module);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentProgramStudent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentProgramStudent)this.getTheObject()).getCreditPoints();
    }
    public Grade4Public getGrade() 
				throws PersistenceException{
        return ((PersistentProgramStudent)this.getTheObject()).getGrade();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentProgramStudent)this.getTheObject()).getName();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentProgramStudent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentProgramStudent)this.getTheObject()).initializeOnInstantiation();
    }

    
}
