package persistence;



import model.visitor.*;

public class NoProgramProxi extends ProgramStudentProxi implements PersistentNoProgram{
    
    public NoProgramProxi(long objectId) {
        super(objectId);
    }
    public NoProgramProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 285;
    }
    
    public PersistentNoProgram getThis() throws PersistenceException {
        return ((PersistentNoProgram)this.getTheObject()).getThis();
    }
    
    public void accept(ProgramStudentVisitor visitor) throws PersistenceException {
        visitor.handleNoProgram(this);
    }
    public <R> R accept(ProgramStudentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoProgram(this);
    }
    public <E extends model.UserException>  void accept(ProgramStudentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoProgram(this);
    }
    public <R, E extends model.UserException> R accept(ProgramStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoProgram(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoProgram(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoProgram(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoProgram(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoProgram(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleNoProgram(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoProgram(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoProgram(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoProgram(this);
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentNoProgram)this.getTheObject()).containsprogramHierarchyStudent(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNoProgram)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentNoProgram)this.getTheObject()).strategyprogramHierarchyStudent(strategy);
    }
    public void addModule(final ModuleAbstractStudent4Public module) 
				throws model.CycleException, PersistenceException{
        ((PersistentNoProgram)this.getTheObject()).addModule(module);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNoProgram)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentNoProgram)this.getTheObject()).getCreditPoints();
    }
    public MyBoolean4Public getFinished() 
				throws PersistenceException{
        return ((PersistentNoProgram)this.getTheObject()).getFinished();
    }
    public Grade4Public getGrade() 
				throws PersistenceException{
        return ((PersistentNoProgram)this.getTheObject()).getGrade();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentNoProgram)this.getTheObject()).getName();
    }
    public common.Fraction getPassedCP() 
				throws PersistenceException{
        return ((PersistentNoProgram)this.getTheObject()).getPassedCP();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNoProgram)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNoProgram)this.getTheObject()).initializeOnInstantiation();
    }

    
}
