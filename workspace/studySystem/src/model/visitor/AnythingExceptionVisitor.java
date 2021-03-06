
package model.visitor;
import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends CommonDateExceptionVisitor<E>,GradeExceptionVisitor<E>,GradeSystemExceptionVisitor<E>,ModuleAbstractExceptionVisitor<E>,ModuleAbstractSGroupExceptionVisitor<E>,ModuleAbstractStudentExceptionVisitor<E>,MyBooleanExceptionVisitor<E>,ProgramStudentExceptionVisitor<E>,ServiceExceptionVisitor<E>,subAdminServiceExceptionVisitor<E>{
    
    public void handleAddModuleToGroupCommand(AddModuleToGroupCommand4Public addModuleToGroupCommand) throws PersistenceException, E;
    public void handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException, E;
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException, E;
    public void handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException, E;
    public void handleAdminServiceServices(AdminServiceServices4Public adminServiceServices) throws PersistenceException, E;
    public void handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException, E;
    public void handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException, E;
    public void handleChangeGradeCommand(ChangeGradeCommand4Public changeGradeCommand) throws PersistenceException, E;
    public void handleChangeGradeSystemCommand(ChangeGradeSystemCommand4Public changeGradeSystemCommand) throws PersistenceException, E;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public void handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException, E;
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException, E;
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException, E;
    public void handleEndStudyGroupCommand(EndStudyGroupCommand4Public endStudyGroupCommand) throws PersistenceException, E;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleGradeChange(GradeChange4Public gradeChange) throws PersistenceException, E;
    public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException, E;
    public void handleProgram(Program4Public program) throws PersistenceException, E;
    public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException, E;
    public void handleProgramModuleServiceModuleManager(ProgramModuleServiceModuleManager4Public programModuleServiceModuleManager) throws PersistenceException, E;
    public void handleProgramModuleServiceProgramManager(ProgramModuleServiceProgramManager4Public programModuleServiceProgramManager) throws PersistenceException, E;
    public void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException, E;
    public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    public void handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException, E;
    public void handleStudent(Student4Public student) throws PersistenceException, E;
    public void handleStudentManageServiceStudentManager(StudentManageServiceStudentManager4Public studentManageServiceStudentManager) throws PersistenceException, E;
    public void handleStudentManager(StudentManager4Public studentManager) throws PersistenceException, E;
    public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException, E;
    public void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException, E;
    public void handleStudyGroupServiceGroupManager(StudyGroupServiceGroupManager4Public studyGroupServiceGroupManager) throws PersistenceException, E;
    public void handleSubj(Subj4Public subj) throws PersistenceException, E;
    public void handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException, E;
    public void handleUnit(Unit4Public unit) throws PersistenceException, E;
    public void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException, E;
    public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException, E;
    
}
