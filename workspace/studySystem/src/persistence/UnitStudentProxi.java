package persistence;



import model.visitor.*;

public class UnitStudentProxi extends PersistentProxi implements PersistentUnitStudent{
    
    public UnitStudentProxi(long objectId) {
        super(objectId);
    }
    public UnitStudentProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 197;
    }
    
    public UnitSGroup4Public getUnitCopy() throws PersistenceException {
        return ((PersistentUnitStudent)this.getTheObject()).getUnitCopy();
    }
    public void setUnitCopy(UnitSGroup4Public newValue) throws PersistenceException {
        ((PersistentUnitStudent)this.getTheObject()).setUnitCopy(newValue);
    }
    public GradesInThird4Public getGrade() throws PersistenceException {
        return ((PersistentUnitStudent)this.getTheObject()).getGrade();
    }
    public void setGrade(GradesInThird4Public newValue) throws PersistenceException {
        ((PersistentUnitStudent)this.getTheObject()).setGrade(newValue);
    }
    public UnitStudent_ChangesProxi getChanges() throws PersistenceException {
        return ((PersistentUnitStudent)this.getTheObject()).getChanges();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentUnitStudent)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentUnitStudent)this.getTheObject()).setSubService(newValue);
    }
    public PersistentUnitStudent getThis() throws PersistenceException {
        return ((PersistentUnitStudent)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitStudent(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitStudent(this);
    }
    public void accept(LectureWithGradeVisitor visitor) throws PersistenceException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends model.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends model.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitStudent(this);
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).containsprogramHierarchyStudent(part);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).register(observee);
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).strategyprogramHierarchyStudent(strategy);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).updateObservers(event);
    }
    public void changeGrade(final Grade4Public grade, final String comment) 
				throws model.AlreadyFinishedException, model.InvalidGradeForSystemException, PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).changeGrade(grade, comment);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCPmulGrade() 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).getCPmulGrade();
    }
    public common.Fraction getCPwithGrade() 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).getCPwithGrade();
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).getCreditPoints();
    }
    public MyBoolean4Public getFinished() 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).getFinished();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).getName();
    }
    public common.Fraction getPassedCP() 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).getPassedCP();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).initializeOnInstantiation();
    }

    
}
