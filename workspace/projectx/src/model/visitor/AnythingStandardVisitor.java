
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
    public void handleT_3_7(T_3_74Public t_3_7) throws PersistenceException{
        this.standardHandling(t_3_7);
    }
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException{
        this.standardHandling(moduleGroup);
    }
    public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException{
        this.standardHandling(moduleManager);
    }
    public void handleUnit(Unit4Public unit) throws PersistenceException{
        this.standardHandling(unit);
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
    public void handleZ_1_0(Z_1_04Public z_1_0) throws PersistenceException{
        this.standardHandling(z_1_0);
    }
    public void handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException{
        this.standardHandling(addModuleToProgCommand);
    }
    public void handleZ_1_1(Z_1_14Public z_1_1) throws PersistenceException{
        this.standardHandling(z_1_1);
    }
    public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException{
        this.standardHandling(programManager);
    }
    public void handleZ_3_0(Z_3_04Public z_3_0) throws PersistenceException{
        this.standardHandling(z_3_0);
    }
    public void handleZ_1_2(Z_1_24Public z_1_2) throws PersistenceException{
        this.standardHandling(z_1_2);
    }
    public void handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGradeSystem) throws PersistenceException{
        this.standardHandling(simpleGradeSystem);
    }
    public void handleZ_4_0(Z_4_04Public z_4_0) throws PersistenceException{
        this.standardHandling(z_4_0);
    }
    public void handleZ_2_2(Z_2_24Public z_2_2) throws PersistenceException{
        this.standardHandling(z_2_2);
    }
    public void handleZ_2_3(Z_2_34Public z_2_3) throws PersistenceException{
        this.standardHandling(z_2_3);
    }
    public void handleZ_2_4(Z_2_44Public z_2_4) throws PersistenceException{
        this.standardHandling(z_2_4);
    }
    public void handleProgram(Program4Public program) throws PersistenceException{
        this.standardHandling(program);
    }
    public void handleZ_2_5(Z_2_54Public z_2_5) throws PersistenceException{
        this.standardHandling(z_2_5);
    }
    public void handleZ_2_6(Z_2_64Public z_2_6) throws PersistenceException{
        this.standardHandling(z_2_6);
    }
    public void handleChangeGradeOfUnitCommand(ChangeGradeOfUnitCommand4Public changeGradeOfUnitCommand) throws PersistenceException{
        this.standardHandling(changeGradeOfUnitCommand);
    }
    public void handleZ_2_7(Z_2_74Public z_2_7) throws PersistenceException{
        this.standardHandling(z_2_7);
    }
    public void handleZ_2_8(Z_2_84Public z_2_8) throws PersistenceException{
        this.standardHandling(z_2_8);
    }
    public void handleZ_2_9(Z_2_94Public z_2_9) throws PersistenceException{
        this.standardHandling(z_2_9);
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
    public void handleT_4_0(T_4_04Public t_4_0) throws PersistenceException{
        this.standardHandling(t_4_0);
    }
    public void handleT_2_0(T_2_04Public t_2_0) throws PersistenceException{
        this.standardHandling(t_2_0);
    }
    public void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException{
        this.standardHandling(studyGroupManager);
    }
    public void handleT_2_7(T_2_74Public t_2_7) throws PersistenceException{
        this.standardHandling(t_2_7);
    }
    public void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException{
        this.standardHandling(unitStudent);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleChangeGradeOfModuleCommand(ChangeGradeOfModuleCommand4Public changeGradeOfModuleCommand) throws PersistenceException{
        this.standardHandling(changeGradeOfModuleCommand);
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
    public void handleNoGrade(NoGrade4Public noGrade) throws PersistenceException{
        this.standardHandling(noGrade);
    }
    public void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException{
        this.standardHandling(notPassed);
    }
    public void handleZ_2_0(Z_2_04Public z_2_0) throws PersistenceException{
        this.standardHandling(z_2_0);
    }
    public void handleZ_2_1(Z_2_14Public z_2_1) throws PersistenceException{
        this.standardHandling(z_2_1);
    }
    public void handleZ_3_1(Z_3_14Public z_3_1) throws PersistenceException{
        this.standardHandling(z_3_1);
    }
    public void handleZ_1_3(Z_1_34Public z_1_3) throws PersistenceException{
        this.standardHandling(z_1_3);
    }
    public void handleZ_5_0(Z_5_04Public z_5_0) throws PersistenceException{
        this.standardHandling(z_5_0);
    }
    public void handleZ_3_2(Z_3_24Public z_3_2) throws PersistenceException{
        this.standardHandling(z_3_2);
    }
    public void handleZ_1_4(Z_1_44Public z_1_4) throws PersistenceException{
        this.standardHandling(z_1_4);
    }
    public void handleZ_3_3(Z_3_34Public z_3_3) throws PersistenceException{
        this.standardHandling(z_3_3);
    }
    public void handleZ_1_5(Z_1_54Public z_1_5) throws PersistenceException{
        this.standardHandling(z_1_5);
    }
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent) throws PersistenceException{
        this.standardHandling(moduleWithUnitsStudent);
    }
    public void handleZ_3_4(Z_3_44Public z_3_4) throws PersistenceException{
        this.standardHandling(z_3_4);
    }
    public void handleZ_1_6(Z_1_64Public z_1_6) throws PersistenceException{
        this.standardHandling(z_1_6);
    }
    public void handleZ_3_5(Z_3_54Public z_3_5) throws PersistenceException{
        this.standardHandling(z_3_5);
    }
    public void handleZ_1_7(Z_1_74Public z_1_7) throws PersistenceException{
        this.standardHandling(z_1_7);
    }
    public void handleZ_3_6(Z_3_64Public z_3_6) throws PersistenceException{
        this.standardHandling(z_3_6);
    }
    public void handleZ_1_8(Z_1_84Public z_1_8) throws PersistenceException{
        this.standardHandling(z_1_8);
    }
    public void handleChangeGradeSystemCommand(ChangeGradeSystemCommand4Public changeGradeSystemCommand) throws PersistenceException{
        this.standardHandling(changeGradeSystemCommand);
    }
    public void handleZ_3_7(Z_3_74Public z_3_7) throws PersistenceException{
        this.standardHandling(z_3_7);
    }
    public void handleZ_1_9(Z_1_94Public z_1_9) throws PersistenceException{
        this.standardHandling(z_1_9);
    }
    public void handleZ_3_8(Z_3_84Public z_3_8) throws PersistenceException{
        this.standardHandling(z_3_8);
    }
    public void handleZ_3_9(Z_3_94Public z_3_9) throws PersistenceException{
        this.standardHandling(z_3_9);
    }
    public void handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException{
        this.standardHandling(changeCPOnUnitCommand);
    }
    public void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException{
        this.standardHandling(moduleGroupStudent);
    }
    public void handleT_5_0(T_5_04Public t_5_0) throws PersistenceException{
        this.standardHandling(t_5_0);
    }
    public void handleT_1_3(T_1_34Public t_1_3) throws PersistenceException{
        this.standardHandling(t_1_3);
    }
    public void handleT_3_0(T_3_04Public t_3_0) throws PersistenceException{
        this.standardHandling(t_3_0);
    }
    public void handleT_1_7(T_1_74Public t_1_7) throws PersistenceException{
        this.standardHandling(t_1_7);
    }
    public void handleT_3_3(T_3_34Public t_3_3) throws PersistenceException{
        this.standardHandling(t_3_3);
    }
    public void handleT_1_0(T_1_04Public t_1_0) throws PersistenceException{
        this.standardHandling(t_1_0);
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
