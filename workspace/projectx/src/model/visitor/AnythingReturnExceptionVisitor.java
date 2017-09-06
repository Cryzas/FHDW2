
package model.visitor;
import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends CommonDateReturnExceptionVisitor<R, E> ,GradeSystemReturnExceptionVisitor<R, E> ,GradesInSimpleOrThirdReturnExceptionVisitor<R, E> ,GradesInTenthReturnExceptionVisitor<R, E> ,ModuleAbstractReturnExceptionVisitor<R, E> ,ModuleAbstractSGroupReturnExceptionVisitor<R, E> ,ModuleAbstractStudentReturnExceptionVisitor<R, E> {
    
    public R handleAddModuleToGroupCommand(AddModuleToGroupCommand4Public addModuleToGroupCommand) throws PersistenceException, E;
    public R handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException, E;
    public R handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException, E;
    public R handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException, E;
    public R handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException, E;
    public R handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException, E;
    public R handleChangeGradeOfModuleSimpleCommand(ChangeGradeOfModuleSimpleCommand4Public changeGradeOfModuleSimpleCommand) throws PersistenceException, E;
    public R handleChangeGradeOfModuleThirdCommand(ChangeGradeOfModuleThirdCommand4Public changeGradeOfModuleThirdCommand) throws PersistenceException, E;
    public R handleChangeGradeOfUnitCommand(ChangeGradeOfUnitCommand4Public changeGradeOfUnitCommand) throws PersistenceException, E;
    public R handleChangeGradeSystemCommand(ChangeGradeSystemCommand4Public changeGradeSystemCommand) throws PersistenceException, E;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public R handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException, E;
    public R handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException, E;
    public R handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException, E;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public R handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException, E;
    public R handleProgram(Program4Public program) throws PersistenceException, E;
    public R handleProgramManager(ProgramManager4Public programManager) throws PersistenceException, E;
    public R handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException, E;
    public R handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException, E;
    public R handleServer(Server4Public server) throws PersistenceException, E;
    public R handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException, E;
    public R handleStudent(Student4Public student) throws PersistenceException, E;
    public R handleStudentManager(StudentManager4Public studentManager) throws PersistenceException, E;
    public R handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException, E;
    public R handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException, E;
    public R handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException, E;
    public R handleUnit(Unit4Public unit) throws PersistenceException, E;
    public R handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException, E;
    public R handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException, E;
    
}
