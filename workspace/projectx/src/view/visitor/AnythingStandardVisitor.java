
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handlePassed(PassedView passed) throws ModelException{
        this.standardHandling(passed);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleProgramSGroup(ProgramSGroupView programSGroup) throws ModelException{
        this.standardHandling(programSGroup);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleModuleGroupSGroup(ModuleGroupSGroupView moduleGroupSGroup) throws ModelException{
        this.standardHandling(moduleGroupSGroup);
    }
    public void handleModuleAtomarSGroup(ModuleAtomarSGroupView moduleAtomarSGroup) throws ModelException{
        this.standardHandling(moduleAtomarSGroup);
    }
    public void handleModuleAtomar(ModuleAtomarView moduleAtomar) throws ModelException{
        this.standardHandling(moduleAtomar);
    }
    public void handleModuleManager(ModuleManagerView moduleManager) throws ModelException{
        this.standardHandling(moduleManager);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException{
        this.standardHandling(moduleGroup);
    }
    public void handleThirdGradeSystem(ThirdGradeSystemView thirdGradeSystem) throws ModelException{
        this.standardHandling(thirdGradeSystem);
    }
    public void handleStudyGroup(StudyGroupView studyGroup) throws ModelException{
        this.standardHandling(studyGroup);
    }
    public void handleNoGradeThird(NoGradeThirdView noGradeThird) throws ModelException{
        this.standardHandling(noGradeThird);
    }
    public void handleProgramManager(ProgramManagerView programManager) throws ModelException{
        this.standardHandling(programManager);
    }
    public void handleSimpleGradeSystem(SimpleGradeSystemView simpleGradeSystem) throws ModelException{
        this.standardHandling(simpleGradeSystem);
    }
    public void handleNoGradeSimple(NoGradeSimpleView noGradeSimple) throws ModelException{
        this.standardHandling(noGradeSimple);
    }
    public void handleProgram(ProgramView program) throws ModelException{
        this.standardHandling(program);
    }
    public void handleUnitSGroup(UnitSGroupView unitSGroup) throws ModelException{
        this.standardHandling(unitSGroup);
    }
    public void handleStudentManager(StudentManagerView studentManager) throws ModelException{
        this.standardHandling(studentManager);
    }
    public void handleStudent(StudentView student) throws ModelException{
        this.standardHandling(student);
    }
    public void handleT_2_3(T_2_3View t_2_3) throws ModelException{
        this.standardHandling(t_2_3);
    }
    public void handleT_2_0(T_2_0View t_2_0) throws ModelException{
        this.standardHandling(t_2_0);
    }
    public void handleStudyGroupManager(StudyGroupManagerView studyGroupManager) throws ModelException{
        this.standardHandling(studyGroupManager);
    }
    public void handleUnitStudent(UnitStudentView unitStudent) throws ModelException{
        this.standardHandling(unitStudent);
    }
    public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroupView moduleWithUnitsSGroup) throws ModelException{
        this.standardHandling(moduleWithUnitsSGroup);
    }
    public void handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException{
        this.standardHandling(moduleAtomarStudent);
    }
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleProgramStudent(ProgramStudentView programStudent) throws ModelException{
        this.standardHandling(programStudent);
    }
    public void handleNotPassed(NotPassedView notPassed) throws ModelException{
        this.standardHandling(notPassed);
    }
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudentView moduleWithUnitsStudent) throws ModelException{
        this.standardHandling(moduleWithUnitsStudent);
    }
    public void handleModuleGroupStudent(ModuleGroupStudentView moduleGroupStudent) throws ModelException{
        this.standardHandling(moduleGroupStudent);
    }
    public void handleT_1_3(T_1_3View t_1_3) throws ModelException{
        this.standardHandling(t_1_3);
    }
    public void handleT_1_7(T_1_7View t_1_7) throws ModelException{
        this.standardHandling(t_1_7);
    }
    public void handleT_1_0(T_1_0View t_1_0) throws ModelException{
        this.standardHandling(t_1_0);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
