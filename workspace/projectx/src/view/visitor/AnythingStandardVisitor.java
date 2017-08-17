
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleProgramSGroup(ProgramSGroupView programSGroup) throws ModelException{
        this.standardHandling(programSGroup);
    }
    public void handleModuleGroupSGroup(ModuleGroupSGroupView moduleGroupSGroup) throws ModelException{
        this.standardHandling(moduleGroupSGroup);
    }
    public void handleModuleAtomarSGroup(ModuleAtomarSGroupView moduleAtomarSGroup) throws ModelException{
        this.standardHandling(moduleAtomarSGroup);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleModuleAtomar(ModuleAtomarView moduleAtomar) throws ModelException{
        this.standardHandling(moduleAtomar);
    }
    public void handleModuleGroup(ModuleGroupView moduleGroup) throws ModelException{
        this.standardHandling(moduleGroup);
    }
    public void handleModuleManager(ModuleManagerView moduleManager) throws ModelException{
        this.standardHandling(moduleManager);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    public void handleStudyGroup(StudyGroupView studyGroup) throws ModelException{
        this.standardHandling(studyGroup);
    }
    public void handleModuleAtomarStudent(ModuleAtomarStudentView moduleAtomarStudent) throws ModelException{
        this.standardHandling(moduleAtomarStudent);
    }
    public void handleThirdGrade(ThirdGradeView thirdGrade) throws ModelException{
        this.standardHandling(thirdGrade);
    }
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleProgramStudent(ProgramStudentView programStudent) throws ModelException{
        this.standardHandling(programStudent);
    }
    public void handleProgramManager(ProgramManagerView programManager) throws ModelException{
        this.standardHandling(programManager);
    }
    public void handleSimpleGrade(SimpleGradeView simpleGrade) throws ModelException{
        this.standardHandling(simpleGrade);
    }
    public void handleProgram(ProgramView program) throws ModelException{
        this.standardHandling(program);
    }
    public void handleModuleWithUnitsStudent(ModuleWithUnitsStudentView moduleWithUnitsStudent) throws ModelException{
        this.standardHandling(moduleWithUnitsStudent);
    }
    public void handleTenthGrade(TenthGradeView tenthGrade) throws ModelException{
        this.standardHandling(tenthGrade);
    }
    public void handleUnitSGroup(UnitSGroupView unitSGroup) throws ModelException{
        this.standardHandling(unitSGroup);
    }
    public void handleStudentManager(StudentManagerView studentManager) throws ModelException{
        this.standardHandling(studentManager);
    }
    public void handleModuleGroupStudent(ModuleGroupStudentView moduleGroupStudent) throws ModelException{
        this.standardHandling(moduleGroupStudent);
    }
    public void handleStudent(StudentView student) throws ModelException{
        this.standardHandling(student);
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
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
