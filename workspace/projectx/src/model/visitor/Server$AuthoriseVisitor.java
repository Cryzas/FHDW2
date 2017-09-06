
package model.visitor;

import persistence.*;

public abstract class Server$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handlePassed(PersistentPassed passed) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleProgramSGroup(PersistentProgramSGroup programSGroup) throws PersistenceException;
    public abstract void handleModuleGroupSGroup(PersistentModuleGroupSGroup moduleGroupSGroup) throws PersistenceException;
    public abstract void handleModuleAtomarSGroup(PersistentModuleAtomarSGroup moduleAtomarSGroup) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleModuleAtomar(PersistentModuleAtomar moduleAtomar) throws PersistenceException;
    public abstract void handleT_3_7(PersistentT_3_7 t_3_7) throws PersistenceException;
    public abstract void handleModuleGroup(PersistentModuleGroup moduleGroup) throws PersistenceException;
    public abstract void handleUnit(PersistentUnit unit) throws PersistenceException;
    public abstract void handleModuleManager(PersistentModuleManager moduleManager) throws PersistenceException;
    public abstract void handleThirdGradeSystem(PersistentThirdGradeSystem thirdGradeSystem) throws PersistenceException;
    public abstract void handleStudyGroup(PersistentStudyGroup studyGroup) throws PersistenceException;
    public abstract void handleNoGradeThird(PersistentNoGradeThird noGradeThird) throws PersistenceException;
    public abstract void handleZ_1_0(PersistentZ_1_0 z_1_0) throws PersistenceException;
    public abstract void handleZ_1_1(PersistentZ_1_1 z_1_1) throws PersistenceException;
    public abstract void handleProgramManager(PersistentProgramManager programManager) throws PersistenceException;
    public abstract void handleZ_3_0(PersistentZ_3_0 z_3_0) throws PersistenceException;
    public abstract void handleZ_1_2(PersistentZ_1_2 z_1_2) throws PersistenceException;
    public abstract void handleSimpleGradeSystem(PersistentSimpleGradeSystem simpleGradeSystem) throws PersistenceException;
    public abstract void handleZ_4_0(PersistentZ_4_0 z_4_0) throws PersistenceException;
    public abstract void handleZ_2_2(PersistentZ_2_2 z_2_2) throws PersistenceException;
    public abstract void handleZ_2_3(PersistentZ_2_3 z_2_3) throws PersistenceException;
    public abstract void handleZ_2_4(PersistentZ_2_4 z_2_4) throws PersistenceException;
    public abstract void handleProgram(PersistentProgram program) throws PersistenceException;
    public abstract void handleZ_2_5(PersistentZ_2_5 z_2_5) throws PersistenceException;
    public abstract void handleZ_2_6(PersistentZ_2_6 z_2_6) throws PersistenceException;
    public abstract void handleZ_2_7(PersistentZ_2_7 z_2_7) throws PersistenceException;
    public abstract void handleZ_2_8(PersistentZ_2_8 z_2_8) throws PersistenceException;
    public abstract void handleZ_2_9(PersistentZ_2_9 z_2_9) throws PersistenceException;
    public abstract void handleUnitSGroup(PersistentUnitSGroup unitSGroup) throws PersistenceException;
    public abstract void handleStudentManager(PersistentStudentManager studentManager) throws PersistenceException;
    public abstract void handleStudent(PersistentStudent student) throws PersistenceException;
    public abstract void handleT_2_3(PersistentT_2_3 t_2_3) throws PersistenceException;
    public abstract void handleT_4_0(PersistentT_4_0 t_4_0) throws PersistenceException;
    public abstract void handleStudyGroupManager(PersistentStudyGroupManager studyGroupManager) throws PersistenceException;
    public abstract void handleT_2_0(PersistentT_2_0 t_2_0) throws PersistenceException;
    public abstract void handleT_2_7(PersistentT_2_7 t_2_7) throws PersistenceException;
    public abstract void handleUnitStudent(PersistentUnitStudent unitStudent) throws PersistenceException;
    public abstract void handleModuleWithUnitsSGroup(PersistentModuleWithUnitsSGroup moduleWithUnitsSGroup) throws PersistenceException;
    public abstract void handleModuleAtomarStudent(PersistentModuleAtomarStudent moduleAtomarStudent) throws PersistenceException;
    public abstract void handleModuleWithUnits(PersistentModuleWithUnits moduleWithUnits) throws PersistenceException;
    public abstract void handleProgramStudent(PersistentProgramStudent programStudent) throws PersistenceException;
    public abstract void handleNotPassed(PersistentNotPassed notPassed) throws PersistenceException;
    public abstract void handleZ_2_0(PersistentZ_2_0 z_2_0) throws PersistenceException;
    public abstract void handleZ_2_1(PersistentZ_2_1 z_2_1) throws PersistenceException;
    public abstract void handleZ_3_1(PersistentZ_3_1 z_3_1) throws PersistenceException;
    public abstract void handleZ_1_3(PersistentZ_1_3 z_1_3) throws PersistenceException;
    public abstract void handleZ_5_0(PersistentZ_5_0 z_5_0) throws PersistenceException;
    public abstract void handleZ_3_2(PersistentZ_3_2 z_3_2) throws PersistenceException;
    public abstract void handleZ_1_4(PersistentZ_1_4 z_1_4) throws PersistenceException;
    public abstract void handleZ_3_3(PersistentZ_3_3 z_3_3) throws PersistenceException;
    public abstract void handleZ_1_5(PersistentZ_1_5 z_1_5) throws PersistenceException;
    public abstract void handleModuleWithUnitsStudent(PersistentModuleWithUnitsStudent moduleWithUnitsStudent) throws PersistenceException;
    public abstract void handleZ_3_4(PersistentZ_3_4 z_3_4) throws PersistenceException;
    public abstract void handleZ_1_6(PersistentZ_1_6 z_1_6) throws PersistenceException;
    public abstract void handleZ_3_5(PersistentZ_3_5 z_3_5) throws PersistenceException;
    public abstract void handleZ_1_7(PersistentZ_1_7 z_1_7) throws PersistenceException;
    public abstract void handleZ_3_6(PersistentZ_3_6 z_3_6) throws PersistenceException;
    public abstract void handleZ_1_8(PersistentZ_1_8 z_1_8) throws PersistenceException;
    public abstract void handleZ_3_7(PersistentZ_3_7 z_3_7) throws PersistenceException;
    public abstract void handleZ_1_9(PersistentZ_1_9 z_1_9) throws PersistenceException;
    public abstract void handleZ_3_8(PersistentZ_3_8 z_3_8) throws PersistenceException;
    public abstract void handleZ_3_9(PersistentZ_3_9 z_3_9) throws PersistenceException;
    public abstract void handleModuleGroupStudent(PersistentModuleGroupStudent moduleGroupStudent) throws PersistenceException;
    public abstract void handleT_5_0(PersistentT_5_0 t_5_0) throws PersistenceException;
    public abstract void handleNoGradeTenth(PersistentNoGradeTenth noGradeTenth) throws PersistenceException;
    public abstract void handleT_1_3(PersistentT_1_3 t_1_3) throws PersistenceException;
    public abstract void handleT_3_0(PersistentT_3_0 t_3_0) throws PersistenceException;
    public abstract void handleT_1_7(PersistentT_1_7 t_1_7) throws PersistenceException;
    public abstract void handleT_3_3(PersistentT_3_3 t_3_3) throws PersistenceException;
    public abstract void handleT_1_0(PersistentT_1_0 t_1_0) throws PersistenceException;
    
}
