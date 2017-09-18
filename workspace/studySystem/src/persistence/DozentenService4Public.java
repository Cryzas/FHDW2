package persistence;


import model.visitor.*;

public interface DozentenService4Public extends subAdminService4Public {
    
    public ProgramManager4Public getProgramManager() throws PersistenceException ;
    public ModuleManager4Public getModuleManager() throws PersistenceException ;
    public StudyGroupManager4Public getGroupManager() throws PersistenceException ;
    public StudentManager4Public getStudentManager() throws PersistenceException ;
    
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
    public String dozentenService_Menu_Filter(final Anything anything) 
				throws PersistenceException;
    public UnitSGroupSearchList fromUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException;
    public StudyGroupSearchList groups_Path_In_DeleteStudyGroups(final StudyGroupManager4Public manager) 
				throws model.UserException, PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public ModuleAbstractStudentSearchList lecture_Path_In_ChangeGradeforStudent(final Student4Public student) 
				throws model.UserException, PersistenceException;
    public ModuleAbstractSearchList modules_Path_In_AddModuleToGroup() 
				throws model.UserException, PersistenceException;
    public ModuleAbstractSearchList modules_Path_In_AddModuleToProg() 
				throws model.UserException, PersistenceException;
    public ModuleAbstractSearchList modules_Path_In_DeleteModules(final ModuleManager4Public manager) 
				throws model.UserException, PersistenceException;
    public ModuleAbstractSearchList modules_Path_In_RemoveModuleFromGroup(final ModuleGroup4Public group) 
				throws model.UserException, PersistenceException;
    public ModuleAbstractSearchList modules_Path_In_RemoveModuleFromProg(final Program4Public program) 
				throws model.UserException, PersistenceException;
    public ProgramSearchList programs_Path_In_DeletePrograms(final ProgramManager4Public manager) 
				throws model.UserException, PersistenceException;
    public StudentSearchList students_Path_In_AddStudentToGroup() 
				throws model.UserException, PersistenceException;
    public StudentSearchList students_Path_In_DeleteStudents(final StudentManager4Public manager) 
				throws model.UserException, PersistenceException;
    public StudentSearchList students_Path_In_RemoveStudentFromGroup(final StudyGroup4Public group) 
				throws model.UserException, PersistenceException;
    public UnitSearchList units_Path_In_RemoveUnit(final ModuleWithUnits4Public module) 
				throws model.UserException, PersistenceException;
    public void addModuleToGroup(final ModuleGroup4Public group, final ModuleAbstractSearchList modules) 
				throws PersistenceException;
    public void addModuleToProg(final Program4Public program, final ModuleAbstractSearchList modules) 
				throws PersistenceException;
    public void addStudentToGroup(final StudyGroup4Public group, final StudentSearchList students) 
				throws PersistenceException;
    public void addUnit(final ModuleWithUnits4Public module, final String name, final common.Fraction creditPoints) 
				throws PersistenceException;
    public void changeCPOnModule(final ModuleAtomar4Public module, final common.Fraction creditPoints) 
				throws PersistenceException;
    public void changeCPOnUnit(final Unit4Public unit, final common.Fraction creditPoints) 
				throws PersistenceException;
    public void changeGradeOfModule(final ModuleAtomarStudent4Public module, final String grade, final String comment) 
				throws PersistenceException;
    public void changeGradeOfUnit(final UnitStudent4Public unit, final String grade, final String comment) 
				throws PersistenceException;
    public void changeGradeSystem(final ModuleAtomar4Public module) 
				throws PersistenceException;
    public void changeGradeforStudent(final Student4Public student, final LectureWithGrade lecture, final String grade, final String comment) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createModule(final String type, final String name) 
				throws PersistenceException;
    public void createProgram(final String name) 
				throws PersistenceException;
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws PersistenceException;
    public void deleteModules(final ModuleManager4Public manager, final ModuleAbstractSearchList modules) 
				throws PersistenceException;
    public void deletePrograms(final ProgramManager4Public manager, final ProgramSearchList programs) 
				throws PersistenceException;
    public void deleteStudents(final StudentManager4Public manager, final StudentSearchList students) 
				throws PersistenceException;
    public void deleteStudyGroups(final StudyGroupManager4Public manager, final StudyGroupSearchList groups) 
				throws PersistenceException;
    public void endStudyGroup(final StudyGroup4Public studyGroup) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void removeModuleFromGroup(final ModuleGroup4Public group, final ModuleAbstractSearchList modules) 
				throws PersistenceException;
    public void removeModuleFromProg(final Program4Public program, final ModuleAbstractSearchList modules) 
				throws PersistenceException;
    public void removeStudentFromGroup(final StudyGroup4Public group, final StudentSearchList students) 
				throws PersistenceException;
    public void removeUnit(final ModuleWithUnits4Public module, final UnitSearchList units) 
				throws PersistenceException;
    public void startStudyGroup(final Program4Public program, final String name) 
				throws PersistenceException;
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws PersistenceException;

}

