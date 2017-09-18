package persistence;


import model.visitor.*;

public interface StudyGroupService4Public extends subAdminService4Public {
    
    
    public void accept(subAdminServiceVisitor visitor) throws PersistenceException;
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public UnitSGroupSearchList ToUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException;
    public UnitSGroupSearchList fromUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException;
    public StudyGroupManager4Public getGroupManager() 
				throws PersistenceException;
    public StudyGroupSearchList groups_Path_In_DeleteStudyGroups(final StudyGroupManager4Public manager) 
				throws model.UserException, PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public ModuleAbstractStudentSearchList lecture_Path_In_ChangeGradeforStudent(final Student4Public student) 
				throws model.UserException, PersistenceException;
    public StudentSearchList students_Path_In_AddStudentToGroup() 
				throws model.UserException, PersistenceException;
    public StudentSearchList students_Path_In_RemoveStudentFromGroup(final StudyGroup4Public group) 
				throws model.UserException, PersistenceException;
    public String studyGroupService_Menu_Filter(final Anything anything) 
				throws PersistenceException;
    public void addStudentToGroup(final StudyGroup4Public group, final StudentSearchList students) 
				throws PersistenceException;
    public void changeGradeforStudent(final Student4Public student, final LectureWithGrade lecture, final String grade, final String comment) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws PersistenceException;
    public void deleteStudyGroups(final StudyGroupManager4Public manager, final StudyGroupSearchList groups) 
				throws PersistenceException;
    public void endStudyGroup(final StudyGroup4Public studyGroup) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void removeStudentFromGroup(final StudyGroup4Public group, final StudentSearchList students) 
				throws PersistenceException;
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws PersistenceException;

}

