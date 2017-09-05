
package model.visitor;
import persistence.*;

public interface AnythingReturnVisitor<R> extends CommonDateReturnVisitor<R> ,GradeSystemReturnVisitor<R> ,GradesInSimpleReturnVisitor<R> ,GradesInThirdReturnVisitor<R> ,ModuleAbstractReturnVisitor<R> ,ModuleAbstractSGroupReturnVisitor<R> ,ModuleAbstractStudentReturnVisitor<R> {
    
    public R handleAddModuleToGroupCommand(AddModuleToGroupCommand4Public addModuleToGroupCommand) throws PersistenceException;
    public R handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException;
    public R handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException;
    public R handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException;
    public R handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException;
    public R handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException;
    public R handleChangeGradeSystemCommand(ChangeGradeSystemCommand4Public changeGradeSystemCommand) throws PersistenceException;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public R handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException;
    public R handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException;
    public R handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public R handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    public R handleProgram(Program4Public program) throws PersistenceException;
    public R handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    public R handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException;
    public R handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    public R handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException;
    public R handleStudent(Student4Public student) throws PersistenceException;
    public R handleStudentManager(StudentManager4Public studentManager) throws PersistenceException;
    public R handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    public R handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException;
    public R handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException;
    public R handleUnit(Unit4Public unit) throws PersistenceException;
    public R handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException;
    public R handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException;
    
}
