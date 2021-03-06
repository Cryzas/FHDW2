package persistence;



import model.visitor.*;

public class ProgramStudentProxi extends PersistentProxi implements PersistentProgramStudent{
    
    public ProgramStudentProxi(long objectId) {
        super(objectId);
    }
    public ProgramStudentProxi(PersistentInCacheProxi object) {
        super(object);
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
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentProgramStudent)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentProgramStudent)this.getTheObject()).setSubService(newValue);
    }
    public PersistentProgramStudent getThis() throws PersistenceException {
        return ((PersistentProgramStudent)this.getTheObject()).getThis();
    }
    
    public void accept(ProgramStudentVisitor visitor) throws PersistenceException {
        visitor.handleProgramStudent(this);
    }
    public <R> R accept(ProgramStudentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramStudent(this);
    }
    public <E extends model.UserException>  void accept(ProgramStudentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramStudent(this);
    }
    public <R, E extends model.UserException> R accept(ProgramStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramStudent(this);
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleProgramStudent(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramStudent(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramStudent(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramStudent(this);
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentProgramStudent)this.getTheObject()).containsprogramHierarchyStudent(part);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentProgramStudent)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentProgramStudent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentProgramStudent)this.getTheObject()).register(observee);
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentProgramStudent)this.getTheObject()).strategyprogramHierarchyStudent(strategy);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentProgramStudent)this.getTheObject()).updateObservers(event);
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
    public MyBoolean4Public getFinished() 
				throws PersistenceException{
        return ((PersistentProgramStudent)this.getTheObject()).getFinished();
    }
    public Grade4Public getGrade() 
				throws PersistenceException{
        return ((PersistentProgramStudent)this.getTheObject()).getGrade();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentProgramStudent)this.getTheObject()).getName();
    }
    public common.Fraction getPassedCP() 
				throws PersistenceException{
        return ((PersistentProgramStudent)this.getTheObject()).getPassedCP();
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
