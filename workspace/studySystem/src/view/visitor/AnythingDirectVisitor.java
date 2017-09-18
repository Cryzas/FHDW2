
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
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleProgramSGroup(ProgramSGroupView programSGroup) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleModuleManager(ModuleManagerView moduleManager) throws ModelException;
    
    public abstract void handleUnit(UnitView unit) throws ModelException;
    
    public abstract void handleGradeChange(GradeChangeView gradeChange) throws ModelException;
    
    public abstract void handleStudyGroup(StudyGroupView studyGroup) throws ModelException;
    
    public abstract void handleGradeSystem(GradeSystemView gradeSystem) throws ModelException;
    
    public void handleSimpleGradeSystem(SimpleGradeSystemView simpleGradeSystem) throws ModelException{
        this.handleGradeSystem(simpleGradeSystem);
    }
    public void handleThirdGradeSystem(ThirdGradeSystemView thirdGradeSystem) throws ModelException{
        this.handleGradeSystem(thirdGradeSystem);
    }
    public abstract void handleProgramStudent(ProgramStudentView programStudent) throws ModelException;
    
    public void handleNoProgram(NoProgramView noProgram) throws ModelException{
        this.handleProgramStudent(noProgram);
    }
    public abstract void handlesubAdminService(subAdminServiceView subAdminService) throws ModelException;
    
    public void handleStudyGroupService(StudyGroupServiceView studyGroupService) throws ModelException{
        this.handlesubAdminService(studyGroupService);
    }
    public void handleStudentManageService(StudentManageServiceView studentManageService) throws ModelException{
        this.handlesubAdminService(studentManageService);
    }
    public void handleUserManagerService(UserManagerServiceView userManagerService) throws ModelException{
        this.handlesubAdminService(userManagerService);
    }
    public void handleProgramModuleService(ProgramModuleServiceView programModuleService) throws ModelException{
        this.handlesubAdminService(programModuleService);
    }
    public abstract void handleProgramManager(ProgramManagerView programManager) throws ModelException;
    
    public abstract void handleProgram(ProgramView program) throws ModelException;
    
    public abstract void handleUnitSGroup(UnitSGroupView unitSGroup) throws ModelException;
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleAdminService(AdminServiceView adminService) throws ModelException{
        this.handleService(adminService);
    }
    public void handleStudentService(StudentServiceView studentService) throws ModelException{
        this.handleService(studentService);
    }
    public abstract void handleGrade(GradeView grade) throws ModelException;
    
    public void handlePassed(PassedView passed) throws ModelException{
        this.handleGrade(passed);
    }
    public void handleT_3_7(T_3_7View t_3_7) throws ModelException{
        this.handleGrade(t_3_7);
    }
    public void handleNoGrade(NoGradeView noGrade) throws ModelException{
        this.handleGrade(noGrade);
    }
    public void handleNotPassed(NotPassedView notPassed) throws ModelException{
        this.handleGrade(notPassed);
    }
    public void handleZ_1_0(Z_1_0View z_1_0) throws ModelException{
        this.handleGrade(z_1_0);
    }
    public void handleZ_1_1(Z_1_1View z_1_1) throws ModelException{
        this.handleGrade(z_1_1);
    }
    public void handleZ_2_0(Z_2_0View z_2_0) throws ModelException{
        this.handleGrade(z_2_0);
    }
    public void handleZ_3_0(Z_3_0View z_3_0) throws ModelException{
        this.handleGrade(z_3_0);
    }
    public void handleZ_1_2(Z_1_2View z_1_2) throws ModelException{
        this.handleGrade(z_1_2);
    }
    public void handleZ_2_1(Z_2_1View z_2_1) throws ModelException{
        this.handleGrade(z_2_1);
    }
    public void handleZ_4_0(Z_4_0View z_4_0) throws ModelException{
        this.handleGrade(z_4_0);
    }
    public void handleZ_2_2(Z_2_2View z_2_2) throws ModelException{
        this.handleGrade(z_2_2);
    }
    public void handleZ_3_1(Z_3_1View z_3_1) throws ModelException{
        this.handleGrade(z_3_1);
    }
    public void handleZ_1_3(Z_1_3View z_1_3) throws ModelException{
        this.handleGrade(z_1_3);
    }
    public void handleZ_2_3(Z_2_3View z_2_3) throws ModelException{
        this.handleGrade(z_2_3);
    }
    public void handleZ_5_0(Z_5_0View z_5_0) throws ModelException{
        this.handleGrade(z_5_0);
    }
    public void handleZ_3_2(Z_3_2View z_3_2) throws ModelException{
        this.handleGrade(z_3_2);
    }
    public void handleZ_1_4(Z_1_4View z_1_4) throws ModelException{
        this.handleGrade(z_1_4);
    }
    public void handleZ_2_4(Z_2_4View z_2_4) throws ModelException{
        this.handleGrade(z_2_4);
    }
    public void handleZ_3_3(Z_3_3View z_3_3) throws ModelException{
        this.handleGrade(z_3_3);
    }
    public void handleZ_1_5(Z_1_5View z_1_5) throws ModelException{
        this.handleGrade(z_1_5);
    }
    public void handleZ_2_5(Z_2_5View z_2_5) throws ModelException{
        this.handleGrade(z_2_5);
    }
    public void handleZ_3_4(Z_3_4View z_3_4) throws ModelException{
        this.handleGrade(z_3_4);
    }
    public void handleZ_1_6(Z_1_6View z_1_6) throws ModelException{
        this.handleGrade(z_1_6);
    }
    public void handleZ_2_6(Z_2_6View z_2_6) throws ModelException{
        this.handleGrade(z_2_6);
    }
    public void handleZ_3_5(Z_3_5View z_3_5) throws ModelException{
        this.handleGrade(z_3_5);
    }
    public void handleZ_1_7(Z_1_7View z_1_7) throws ModelException{
        this.handleGrade(z_1_7);
    }
    public void handleZ_2_7(Z_2_7View z_2_7) throws ModelException{
        this.handleGrade(z_2_7);
    }
    public void handleZ_3_6(Z_3_6View z_3_6) throws ModelException{
        this.handleGrade(z_3_6);
    }
    public void handleZ_1_8(Z_1_8View z_1_8) throws ModelException{
        this.handleGrade(z_1_8);
    }
    public void handleZ_2_8(Z_2_8View z_2_8) throws ModelException{
        this.handleGrade(z_2_8);
    }
    public void handleZ_3_7(Z_3_7View z_3_7) throws ModelException{
        this.handleGrade(z_3_7);
    }
    public void handleZ_1_9(Z_1_9View z_1_9) throws ModelException{
        this.handleGrade(z_1_9);
    }
    public void handleZ_2_9(Z_2_9View z_2_9) throws ModelException{
        this.handleGrade(z_2_9);
    }
    public void handleZ_3_8(Z_3_8View z_3_8) throws ModelException{
        this.handleGrade(z_3_8);
    }
    public void handleZ_3_9(Z_3_9View z_3_9) throws ModelException{
        this.handleGrade(z_3_9);
    }
    public void handleT_2_3(T_2_3View t_2_3) throws ModelException{
        this.handleGrade(t_2_3);
    }
    public void handleT_5_0(T_5_0View t_5_0) throws ModelException{
        this.handleGrade(t_5_0);
    }
    public void handleT_4_0(T_4_0View t_4_0) throws ModelException{
        this.handleGrade(t_4_0);
    }
    public void handleT_1_3(T_1_3View t_1_3) throws ModelException{
        this.handleGrade(t_1_3);
    }
    public void handleT_3_0(T_3_0View t_3_0) throws ModelException{
        this.handleGrade(t_3_0);
    }
    public void handleT_2_0(T_2_0View t_2_0) throws ModelException{
        this.handleGrade(t_2_0);
    }
    public void handleT_2_7(T_2_7View t_2_7) throws ModelException{
        this.handleGrade(t_2_7);
    }
    public void handleT_1_7(T_1_7View t_1_7) throws ModelException{
        this.handleGrade(t_1_7);
    }
    public void handleT_3_3(T_3_3View t_3_3) throws ModelException{
        this.handleGrade(t_3_3);
    }
    public void handleT_1_0(T_1_0View t_1_0) throws ModelException{
        this.handleGrade(t_1_0);
    }
    public abstract void handleStudentManager(StudentManagerView studentManager) throws ModelException;
    
    public abstract void handleMyBoolean(MyBooleanView myBoolean) throws ModelException;
    
    public void handleBFalse(BFalseView bFalse) throws ModelException{
        this.handleMyBoolean(bFalse);
    }
    public void handleBTrue(BTrueView bTrue) throws ModelException{
        this.handleMyBoolean(bTrue);
    }
    public abstract void handleStudent(StudentView student) throws ModelException;
    
    public abstract void handleStudyGroupManager(StudyGroupManagerView studyGroupManager) throws ModelException;
    
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
    
    
}
