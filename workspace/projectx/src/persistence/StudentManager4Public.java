package persistence;


import model.visitor.*;

public interface StudentManager4Public extends Anything, AbstractPersistentProxi {
    
    public StudentManager_StudentsProxi getStudents() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void addStudentToGroup(final StudyGroup4Public group, final Student4Public student, final Invoker invoker) 
				throws PersistenceException;
    public void changeGradeOfModuleSimple(final ModuleAtomarStudent4Public module, final String grade, final Invoker invoker) 
				throws PersistenceException;
    public void changeGradeOfModuleThird(final ModuleAtomarStudent4Public module, final String grade, final Invoker invoker) 
				throws PersistenceException;
    public void changeGradeOfUnit(final UnitStudent4Public unit, final String grade, final Invoker invoker) 
				throws PersistenceException;
    public void createStudent(final String firstName, final String lastName, final java.sql.Date birthDate, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void addStudentToGroup(final StudyGroup4Public group, final Student4Public student) 
				throws model.UserException, PersistenceException;
    public void changeGradeOfModuleSimple(final ModuleAtomarStudent4Public module, final String grade) 
				throws PersistenceException;
    public void changeGradeOfModuleThird(final ModuleAtomarStudent4Public module, final String grade) 
				throws PersistenceException;
    public void changeGradeOfUnit(final UnitStudent4Public unit, final String grade) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createStudent(final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

