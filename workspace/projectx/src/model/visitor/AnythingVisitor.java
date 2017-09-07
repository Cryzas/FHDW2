
package model.visitor;
import persistence.*;

public interface AnythingVisitor extends CommonDateVisitor,GradeVisitor,GradeSystemVisitor,ModuleAbstractVisitor,ModuleAbstractSGroupVisitor,ModuleAbstractStudentVisitor{
    
    public void handleAddModuleToGroupCommand(AddModuleToGroupCommand4Public addModuleToGroupCommand) throws PersistenceException;
    public void handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException;
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException;
    public void handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException;
    public void handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException;
    public void handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException;
    public void handleChangeGradeOfModuleCommand(ChangeGradeOfModuleCommand4Public changeGradeOfModuleCommand) throws PersistenceException;
    public void handleChangeGradeOfUnitCommand(ChangeGradeOfUnitCommand4Public changeGradeOfUnitCommand) throws PersistenceException;
    public void handleChangeGradeSystemCommand(ChangeGradeSystemCommand4Public changeGradeSystemCommand) throws PersistenceException;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public void handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException;
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException;
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    public void handleProgram(Program4Public program) throws PersistenceException;
    public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    public void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException;
    public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    public void handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException;
    public void handleStudent(Student4Public student) throws PersistenceException;
    public void handleStudentManager(StudentManager4Public studentManager) throws PersistenceException;
    public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    public void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException;
    public void handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException;
    public void handleUnit(Unit4Public unit) throws PersistenceException;
    public void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException;
    public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException;
    
}
