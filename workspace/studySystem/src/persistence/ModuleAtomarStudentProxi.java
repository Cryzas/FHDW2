package persistence;



import model.visitor.*;

public class ModuleAtomarStudentProxi extends ModuleAbstractStudentProxi implements PersistentModuleAtomarStudent{
    
    public ModuleAtomarStudentProxi(long objectId) {
        super(objectId);
    }
    public ModuleAtomarStudentProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 191;
    }
    
    public GradesInSimpleOrThird4Public getOwnGrade() throws PersistenceException {
        return ((PersistentModuleAtomarStudent)this.getTheObject()).getOwnGrade();
    }
    public void setOwnGrade(GradesInSimpleOrThird4Public newValue) throws PersistenceException {
        ((PersistentModuleAtomarStudent)this.getTheObject()).setOwnGrade(newValue);
    }
    public ModuleAtomarStudent_ChangesProxi getChanges() throws PersistenceException {
        return ((PersistentModuleAtomarStudent)this.getTheObject()).getChanges();
    }
    public PersistentModuleAtomarStudent getThis() throws PersistenceException {
        return ((PersistentModuleAtomarStudent)this.getTheObject()).getThis();
    }
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public void accept(LectureWithGradeVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends model.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends model.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleAtomarStudent)this.getTheObject()).containsprogramHierarchyStudent(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleAtomarStudent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleAtomarStudent)this.getTheObject()).strategyprogramHierarchyStudent(strategy);
    }
    public void changeGrade(final Grade4Public grade, final String comment) 
				throws model.AlreadyFinishedException, model.InvalidGradeForSystemException, PersistenceException{
        ((PersistentModuleAtomarStudent)this.getTheObject()).changeGrade(grade, comment);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleAtomarStudent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCPmulGrade() 
				throws PersistenceException{
        return ((PersistentModuleAtomarStudent)this.getTheObject()).getCPmulGrade();
    }
    public common.Fraction getCPwithGrade() 
				throws PersistenceException{
        return ((PersistentModuleAtomarStudent)this.getTheObject()).getCPwithGrade();
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleAtomarStudent)this.getTheObject()).getCreditPoints();
    }
    public MyBoolean4Public getFinished() 
				throws PersistenceException{
        return ((PersistentModuleAtomarStudent)this.getTheObject()).getFinished();
    }
    public Grade4Public getGrade() 
				throws PersistenceException{
        return ((PersistentModuleAtomarStudent)this.getTheObject()).getGrade();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentModuleAtomarStudent)this.getTheObject()).getName();
    }
    public common.Fraction getPassedCP() 
				throws PersistenceException{
        return ((PersistentModuleAtomarStudent)this.getTheObject()).getPassedCP();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleAtomarStudent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleAtomarStudent)this.getTheObject()).initializeOnInstantiation();
    }

    
}
