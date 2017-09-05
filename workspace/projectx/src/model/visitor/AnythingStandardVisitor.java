
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handlePassed(Passed4Public passed) throws PersistenceException{
        this.standardHandling(passed);
    }
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException{
        this.standardHandling(createProgramCommand);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException{
        this.standardHandling(programSGroup);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException{
        this.standardHandling(moduleGroupSGroup);
    }
    public void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException{
        this.standardHandling(moduleAtomarSGroup);
    }
    public void handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException{
        this.standardHandling(startStudyGroupCommand);
    }
    public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException{
        this.standardHandling(moduleAtomar);
    }
    public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException{
        this.standardHandling(moduleManager);
    }
    public void handleUnit(Unit4Public unit) throws PersistenceException{
        this.standardHandling(unit);
    }
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException{
        this.standardHandling(moduleGroup);
    }
    public void handleThirdGradeSystem(ThirdGradeSystem4Public thirdGradeSystem) throws PersistenceException{
        this.standardHandling(thirdGradeSystem);
    }
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException{
        this.standardHandling(studyGroup);
    }
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException{
        this.standardHandling(addStudentToGroupCommand);
    }
    public void handleAddModuleToGroupCommand(AddModuleToGroupCommand4Public addModuleToGroupCommand) throws PersistenceException{
        this.standardHandling(addModuleToGroupCommand);
    }
    public void handleNoGradeThird(NoGradeThird4Public noGradeThird) throws PersistenceException{
        this.standardHandling(noGradeThird);
    }
    public void handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException{
        this.standardHandling(addModuleToProgCommand);
    }
    public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException{
        this.standardHandling(programManager);
    }
    public void handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGradeSystem) throws PersistenceException{
        this.standardHandling(simpleGradeSystem);
    }
    public void handleNoGradeSimple(NoGradeSimple4Public noGradeSimple) throws PersistenceException{
        this.standardHandling(noGradeSimple);
    }
    public void handleProgram(Program4Public program) throws PersistenceException{
        this.standardHandling(program);
    }
    public void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException{
        this.standardHandling(unitSGroup);
    }
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException{
        this.standardHandling(createStudentCommand);
    }
    public void handleStudentManager(StudentManager4Public studentManager) throws PersistenceException{
        this.standardHandling(studentManager);
    }
    public void handleStudent(Student4Public student) throws PersistenceException{
        this.standardHandling(student);
    }
    public void handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException{
        this.standardHandling(createModuleCommand);
    }
    public void handleT_2_3(T_2_34Public t_2_3) throws PersistenceException{
        this.standardHandling(t_2_3);
    }
    public void handleT_2_0(T_2_04Public t_2_0) throws PersistenceException{
        this.standardHandling(t_2_0);
    }
    public void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException{
        this.standardHandling(studyGroupManager);
    }
    public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException{
        this.standardHandling(unitStudent);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException{
        this.standardHandling(addUnitCommand);
    }
    public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup) throws PersistenceException{
        this.standardHandling(moduleWithUnitsSGroup);
    }
    public void handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException{
        this.standardHandling(changeCPOnModuleCommand);
    }
    public void handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException{
        this.standardHandling(swapCPonModuleWithUnitsCommand);
    }
    public void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException{
        this.standardHandling(moduleAtomarStudent);
    }
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException{
        this.standardHandling(programStudent);
    }
    public void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException{
        this.standardHandling(notPassed);
    }
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent) throws PersistenceException{
        this.standardHandling(moduleWithUnitsStudent);
    }
    public void handleChangeGradeSystemCommand(ChangeGradeSystemCommand4Public changeGradeSystemCommand) throws PersistenceException{
        this.standardHandling(changeGradeSystemCommand);
    }
    public void handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException{
        this.standardHandling(changeCPOnUnitCommand);
    }
    public void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException{
        this.standardHandling(moduleGroupStudent);
    }
    public void handleT_1_3(T_1_34Public t_1_3) throws PersistenceException{
        this.standardHandling(t_1_3);
    }
    public void handleT_1_7(T_1_74Public t_1_7) throws PersistenceException{
        this.standardHandling(t_1_7);
    }
    public void handleT_1_0(T_1_04Public t_1_0) throws PersistenceException{
        this.standardHandling(t_1_0);
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
