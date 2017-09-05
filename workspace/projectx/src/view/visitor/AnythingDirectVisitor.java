
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleModuleAbstract(ModuleAbstractView moduleAbstract) throws ModelException;
    
    public void handleModuleAtomar(ModuleAtomarView moduleAtomar) throws ModelException{
        this.handleModuleAbstract(moduleAtomar);
    }
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException{
        this.handleModuleAbstract(moduleWithUnits);
    }
    public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException{
        this.handleModuleAbstract(moduleGroup);
    }
    public abstract void handleModuleAbstractSGroup(ModuleAbstractSGroupView moduleAbstractSGroup) throws ModelException;
    
    public void handleModuleGroupSGroup(ModuleGroupSGroupView moduleGroupSGroup) throws ModelException{
        this.handleModuleAbstractSGroup(moduleGroupSGroup);
    }
    public void handleModuleAtomarSGroup(ModuleAtomarSGroupView moduleAtomarSGroup) throws ModelException{
        this.handleModuleAbstractSGroup(moduleAtomarSGroup);
    }
    public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroupView moduleWithUnitsSGroup) throws ModelException{
        this.handleModuleAbstractSGroup(moduleWithUnitsSGroup);
    }
    public abstract void handleProgram(ProgramView program) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleProgramSGroup(ProgramSGroupView programSGroup) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleUnitSGroup(UnitSGroupView unitSGroup) throws ModelException;
    
    public abstract void handleGradesInSimple(GradesInSimpleView gradesInSimple) throws ModelException;
    
    public void handlePassed(PassedView passed) throws ModelException{
        this.handleGradesInSimple(passed);
    }
    public void handleNoGradeSimple(NoGradeSimpleView noGradeSimple) throws ModelException{
        this.handleGradesInSimple(noGradeSimple);
    }
    public void handleNotPassed(NotPassedView notPassed) throws ModelException{
        this.handleGradesInSimple(notPassed);
    }
    public abstract void handleStudentManager(StudentManagerView studentManager) throws ModelException;
    
    public abstract void handleModuleManager(ModuleManagerView moduleManager) throws ModelException;
    
    public abstract void handleUnit(UnitView unit) throws ModelException;
    
    public abstract void handleStudent(StudentView student) throws ModelException;
    
    public abstract void handleStudyGroupManager(StudyGroupManagerView studyGroupManager) throws ModelException;
    
    public abstract void handleStudyGroup(StudyGroupView studyGroup) throws ModelException;
    
    public abstract void handleModuleAbstractStudent(ModuleAbstractStudentView moduleAbstractStudent) throws ModelException;
    
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudentView moduleWithUnitsStudent) throws ModelException{
        this.handleModuleAbstractStudent(moduleWithUnitsStudent);
    }
    public void handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException{
        this.handleModuleAbstractStudent(moduleAtomarStudent);
    }
    public void handleModuleGroupStudent(ModuleGroupStudentView moduleGroupStudent) throws ModelException{
        this.handleModuleAbstractStudent(moduleGroupStudent);
    }
    public abstract void handleUnitStudent(UnitStudentView unitStudent) throws ModelException;
    
    public abstract void handleGradeSystem(GradeSystemView gradeSystem) throws ModelException;
    
    public void handleSimpleGradeSystem(SimpleGradeSystemView simpleGradeSystem) throws ModelException{
        this.handleGradeSystem(simpleGradeSystem);
    }
    public void handleThirdGradeSystem(ThirdGradeSystemView thirdGradeSystem) throws ModelException{
        this.handleGradeSystem(thirdGradeSystem);
    }
    public abstract void handleGradesInThird(GradesInThirdView gradesInThird) throws ModelException;
    
    public void handleT_2_3(T_2_3View t_2_3) throws ModelException{
        this.handleGradesInThird(t_2_3);
    }
    public void handleT_1_3(T_1_3View t_1_3) throws ModelException{
        this.handleGradesInThird(t_1_3);
    }
    public void handleT_2_0(T_2_0View t_2_0) throws ModelException{
        this.handleGradesInThird(t_2_0);
    }
    public void handleT_1_7(T_1_7View t_1_7) throws ModelException{
        this.handleGradesInThird(t_1_7);
    }
    public void handleT_1_0(T_1_0View t_1_0) throws ModelException{
        this.handleGradesInThird(t_1_0);
    }
    public void handleNoGradeThird(NoGradeThirdView noGradeThird) throws ModelException{
        this.handleGradesInThird(noGradeThird);
    }
    public abstract void handleProgramStudent(ProgramStudentView programStudent) throws ModelException;
    
    public abstract void handleProgramManager(ProgramManagerView programManager) throws ModelException;
    
    
}
