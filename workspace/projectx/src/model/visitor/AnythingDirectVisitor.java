
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleModuleAbstract(ModuleAbstract4Public moduleAbstract) throws PersistenceException;
    
    public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException{
        this.handleModuleAbstract(moduleAtomar);
    }
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.handleModuleAbstract(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException{
        this.handleModuleAbstract(moduleGroup);
    }
    public abstract void handleModuleAbstractSGroup(ModuleAbstractSGroup4Public moduleAbstractSGroup) throws PersistenceException;
    
    public void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException{
        this.handleModuleAbstractSGroup(moduleGroupSGroup);
    }
    public void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException{
        this.handleModuleAbstractSGroup(moduleAtomarSGroup);
    }
    public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup) throws PersistenceException{
        this.handleModuleAbstractSGroup(moduleWithUnitsSGroup);
    }
    public abstract void handleProgram(Program4Public program) throws PersistenceException;
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException;
    
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
    public abstract void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException;
    
    public abstract void handleStudentManager(StudentManager4Public studentManager) throws PersistenceException;
    
    public abstract void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    
    public abstract void handleUnit(Unit4Public unit) throws PersistenceException;
    
    public abstract void handleStudent(Student4Public student) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    
    public abstract void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException;
    
    public abstract void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    
    public abstract void handleModuleAbstractStudent(ModuleAbstractStudent4Public moduleAbstractStudent) throws PersistenceException;
    
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent) throws PersistenceException{
        this.handleModuleAbstractStudent(moduleWithUnitsStudent);
    }
    public void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException{
        this.handleModuleAbstractStudent(moduleAtomarStudent);
    }
    public void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException{
        this.handleModuleAbstractStudent(moduleGroupStudent);
    }
    public abstract void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException;
    
    public abstract void handleGradeSystem(GradeSystem4Public gradeSystem) throws PersistenceException;
    
    public void handleSimpleGrade(SimpleGrade4Public simpleGrade) throws PersistenceException{
        this.handleGradeSystem(simpleGrade);
    }
    public void handleTenthGrade(TenthGrade4Public tenthGrade) throws PersistenceException{
        this.handleGradeSystem(tenthGrade);
    }
    public void handleThirdGrade(ThirdGrade4Public thirdGrade) throws PersistenceException{
        this.handleGradeSystem(thirdGrade);
    }
    public abstract void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    
    public abstract void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException{
        this.handleCommonDate(createProgramCommand);
    }
    public void handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException{
        this.handleCommonDate(changeCPOnModuleCommand);
    }
    public void handleChangeGradeSystemCommand(ChangeGradeSystemCommand4Public changeGradeSystemCommand) throws PersistenceException{
        this.handleCommonDate(changeGradeSystemCommand);
    }
    public void handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException{
        this.handleCommonDate(swapCPonModuleWithUnitsCommand);
    }
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException{
        this.handleCommonDate(createStudentCommand);
    }
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException{
        this.handleCommonDate(addStudentToGroupCommand);
    }
    public void handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException{
        this.handleCommonDate(startStudyGroupCommand);
    }
    public void handleAddModuleToGroupCommand(AddModuleToGroupCommand4Public addModuleToGroupCommand) throws PersistenceException{
        this.handleCommonDate(addModuleToGroupCommand);
    }
    public void handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException{
        this.handleCommonDate(changeCPOnUnitCommand);
    }
    public void handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException{
        this.handleCommonDate(createModuleCommand);
    }
    public void handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException{
        this.handleCommonDate(addModuleToProgCommand);
    }
    public void handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException{
        this.handleCommonDate(addUnitCommand);
    }
    public abstract void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    
    public abstract void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    
    
}
