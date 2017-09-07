
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handlePassed(Passed4Public passed) throws PersistenceException;
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException;
    public abstract void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException;
    public abstract void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException;
    public abstract void handleT_3_7(T_3_74Public t_3_7) throws PersistenceException;
    public abstract void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException;
    public abstract void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    public abstract void handleUnit(Unit4Public unit) throws PersistenceException;
    public abstract void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException;
    public abstract void handleThirdGradeSystem(ThirdGradeSystem4Public thirdGradeSystem) throws PersistenceException;
    public abstract void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    public abstract void handleZ_1_0(Z_1_04Public z_1_0) throws PersistenceException;
    public abstract void handleZ_1_1(Z_1_14Public z_1_1) throws PersistenceException;
    public abstract void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    public abstract void handleZ_3_0(Z_3_04Public z_3_0) throws PersistenceException;
    public abstract void handleZ_1_2(Z_1_24Public z_1_2) throws PersistenceException;
    public abstract void handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGradeSystem) throws PersistenceException;
    public abstract void handleZ_4_0(Z_4_04Public z_4_0) throws PersistenceException;
    public abstract void handleZ_2_2(Z_2_24Public z_2_2) throws PersistenceException;
    public abstract void handleZ_2_3(Z_2_34Public z_2_3) throws PersistenceException;
    public abstract void handleZ_2_4(Z_2_44Public z_2_4) throws PersistenceException;
    public abstract void handleProgram(Program4Public program) throws PersistenceException;
    public abstract void handleZ_2_5(Z_2_54Public z_2_5) throws PersistenceException;
    public abstract void handleZ_2_6(Z_2_64Public z_2_6) throws PersistenceException;
    public abstract void handleZ_2_7(Z_2_74Public z_2_7) throws PersistenceException;
    public abstract void handleZ_2_8(Z_2_84Public z_2_8) throws PersistenceException;
    public abstract void handleZ_2_9(Z_2_94Public z_2_9) throws PersistenceException;
    public abstract void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException;
    public abstract void handleStudentManager(StudentManager4Public studentManager) throws PersistenceException;
    public abstract void handleStudent(Student4Public student) throws PersistenceException;
    public abstract void handleT_2_3(T_2_34Public t_2_3) throws PersistenceException;
    public abstract void handleT_4_0(T_4_04Public t_4_0) throws PersistenceException;
    public abstract void handleT_2_0(T_2_04Public t_2_0) throws PersistenceException;
    public abstract void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException;
    public abstract void handleT_2_7(T_2_74Public t_2_7) throws PersistenceException;
    public abstract void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException;
    public abstract void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup) throws PersistenceException;
    public abstract void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException;
    public abstract void handleNoGrade(NoGrade4Public noGrade) throws PersistenceException;
    public abstract void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException;
    public abstract void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    public abstract void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException;
    public abstract void handleZ_2_0(Z_2_04Public z_2_0) throws PersistenceException;
    public abstract void handleZ_2_1(Z_2_14Public z_2_1) throws PersistenceException;
    public abstract void handleZ_3_1(Z_3_14Public z_3_1) throws PersistenceException;
    public abstract void handleZ_1_3(Z_1_34Public z_1_3) throws PersistenceException;
    public abstract void handleZ_5_0(Z_5_04Public z_5_0) throws PersistenceException;
    public abstract void handleZ_3_2(Z_3_24Public z_3_2) throws PersistenceException;
    public abstract void handleZ_1_4(Z_1_44Public z_1_4) throws PersistenceException;
    public abstract void handleZ_3_3(Z_3_34Public z_3_3) throws PersistenceException;
    public abstract void handleZ_1_5(Z_1_54Public z_1_5) throws PersistenceException;
    public abstract void handleZ_3_4(Z_3_44Public z_3_4) throws PersistenceException;
    public abstract void handleZ_1_6(Z_1_64Public z_1_6) throws PersistenceException;
    public abstract void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent) throws PersistenceException;
    public abstract void handleZ_3_5(Z_3_54Public z_3_5) throws PersistenceException;
    public abstract void handleZ_1_7(Z_1_74Public z_1_7) throws PersistenceException;
    public abstract void handleZ_3_6(Z_3_64Public z_3_6) throws PersistenceException;
    public abstract void handleZ_1_8(Z_1_84Public z_1_8) throws PersistenceException;
    public abstract void handleZ_3_7(Z_3_74Public z_3_7) throws PersistenceException;
    public abstract void handleZ_1_9(Z_1_94Public z_1_9) throws PersistenceException;
    public abstract void handleZ_3_8(Z_3_84Public z_3_8) throws PersistenceException;
    public abstract void handleZ_3_9(Z_3_94Public z_3_9) throws PersistenceException;
    public abstract void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException;
    public abstract void handleT_5_0(T_5_04Public t_5_0) throws PersistenceException;
    public abstract void handleT_1_3(T_1_34Public t_1_3) throws PersistenceException;
    public abstract void handleT_3_0(T_3_04Public t_3_0) throws PersistenceException;
    public abstract void handleT_1_7(T_1_74Public t_1_7) throws PersistenceException;
    public abstract void handleT_3_3(T_3_34Public t_3_3) throws PersistenceException;
    public abstract void handleT_1_0(T_1_04Public t_1_0) throws PersistenceException;
    
}
