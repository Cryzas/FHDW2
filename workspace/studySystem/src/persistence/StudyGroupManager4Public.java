package persistence;


import model.visitor.*;

public interface StudyGroupManager4Public extends Anything, SubjInterface, AbstractPersistentProxi {
    
    public StudyGroupManager_GroupsProxi getGroups() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void addStudentToGroup(final StudyGroup4Public group, final Student4Public student) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException;
    public void addStudentToGroup(final StudyGroup4Public group, final Student4Public student, final Invoker invoker) 
				throws PersistenceException;
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException;
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate, final Invoker invoker) 
				throws PersistenceException;
    public void endStudyGroup(final StudyGroup4Public studyGroup, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException;
    public void addStudentToGroupImplementation(final StudyGroup4Public group, final Student4Public student) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createStudentImplementation(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException;
    public void endStudyGroup(final StudyGroup4Public studyGroup) 
				throws model.AlreadyFinishedException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws model.AlreadyFinishedException, model.UnitSwapException, PersistenceException;

}

