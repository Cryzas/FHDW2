package persistence;



import model.visitor.*;

public class StudentManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentStudentManager{
    
    public StudentManagerICProxi(long objectId) {
        super(objectId);
    }
    public StudentManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theStudentManagerFacade
            .getStudentManager(this.getId());
    }
    
    public long getClassId() {
        return 201;
    }
    
    public StudentManager_StudentsProxi getStudents() throws PersistenceException {
        return ((PersistentStudentManager)this.getTheObject()).getStudents();
    }
    public PersistentStudentManager getThis() throws PersistenceException {
        return ((PersistentStudentManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudentManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManager(this);
    }
    
    
    public void addStudentToGroup(final StudyGroup4Public group, final Student4Public student, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentStudentManager)this.getTheObject()).addStudentToGroup(group, student, invoker);
    }
    public void changeGrade(final LectureWithGrade lecture, final String grade, final String comment, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentStudentManager)this.getTheObject()).changeGrade(lecture, grade, comment, invoker);
    }
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentStudentManager)this.getTheObject()).createStudent(group, firstName, lastName, birthDate, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentStudentManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addStudentToGroup(final StudyGroup4Public group, final Student4Public student) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        ((PersistentStudentManager)this.getTheObject()).addStudentToGroup(group, student);
    }
    public void changeGrade(final LectureWithGrade lecture, final String grade, final String comment) 
				throws model.AlreadyFinishedException, model.InvalidGradeForSystemException, PersistenceException{
        ((PersistentStudentManager)this.getTheObject()).changeGrade(lecture, grade, comment);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentStudentManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        ((PersistentStudentManager)this.getTheObject()).createStudent(group, firstName, lastName, birthDate);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentStudentManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentStudentManager)this.getTheObject()).initializeOnInstantiation();
    }

    
}