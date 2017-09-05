
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handlePassed(Passed4Public passed) throws PersistenceException;
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException;
    public abstract void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException;
    public abstract void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException;
    public abstract void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException;
    public abstract void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    public abstract void handleUnit(Unit4Public unit) throws PersistenceException;
    public abstract void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException;
    public abstract void handleThirdGradeSystem(ThirdGradeSystem4Public thirdGradeSystem) throws PersistenceException;
    public abstract void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    public abstract void handleNoGradeThird(NoGradeThird4Public noGradeThird) throws PersistenceException;
    public abstract void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    public abstract void handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGradeSystem) throws PersistenceException;
    public abstract void handleNoGradeSimple(NoGradeSimple4Public noGradeSimple) throws PersistenceException;
    public abstract void handleProgram(Program4Public program) throws PersistenceException;
    public abstract void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException;
    public abstract void handleStudentManager(StudentManager4Public studentManager) throws PersistenceException;
    public abstract void handleStudent(Student4Public student) throws PersistenceException;
    public abstract void handleT_2_3(T_2_34Public t_2_3) throws PersistenceException;
    public abstract void handleT_2_0(T_2_04Public t_2_0) throws PersistenceException;
    public abstract void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException;
    public abstract void handleUnitStudent(UnitStudent4Public unitStudent) throws PersistenceException;
    public abstract void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup) throws PersistenceException;
    public abstract void handleModuleAtomarStudent(ModuleAtomarStudent4Public moduleAtomarStudent) throws PersistenceException;
    public abstract void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException;
    public abstract void handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException;
    public abstract void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException;
    public abstract void handleModuleWithUnitsStudent(ModuleWithUnitsStudent4Public moduleWithUnitsStudent) throws PersistenceException;
    public abstract void handleModuleGroupStudent(ModuleGroupStudent4Public moduleGroupStudent) throws PersistenceException;
    public abstract void handleT_1_3(T_1_34Public t_1_3) throws PersistenceException;
    public abstract void handleT_1_7(T_1_74Public t_1_7) throws PersistenceException;
    public abstract void handleT_1_0(T_1_04Public t_1_0) throws PersistenceException;
    
}
