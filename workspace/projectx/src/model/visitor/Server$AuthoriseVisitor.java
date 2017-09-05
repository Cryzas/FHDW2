
package model.visitor;

import persistence.*;

public abstract class Server$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleProgramSGroup(PersistentProgramSGroup programSGroup) throws PersistenceException;
    public abstract void handleModuleGroupSGroup(PersistentModuleGroupSGroup moduleGroupSGroup) throws PersistenceException;
    public abstract void handleModuleAtomarSGroup(PersistentModuleAtomarSGroup moduleAtomarSGroup) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleModuleAtomar(PersistentModuleAtomar moduleAtomar) throws PersistenceException;
    public abstract void handleModuleGroup(PersistentModuleGroup moduleGroup) throws PersistenceException;
    public abstract void handleUnit(PersistentUnit unit) throws PersistenceException;
    public abstract void handleModuleManager(PersistentModuleManager moduleManager) throws PersistenceException;
    public abstract void handleThirdGradeSystem(PersistentThirdGradeSystem thirdGradeSystem) throws PersistenceException;
    public abstract void handleStudyGroup(PersistentStudyGroup studyGroup) throws PersistenceException;
    public abstract void handleModuleAtomarStudent(PersistentModuleAtomarStudent moduleAtomarStudent) throws PersistenceException;
    public abstract void handleModuleWithUnits(PersistentModuleWithUnits moduleWithUnits) throws PersistenceException;
    public abstract void handleProgramStudent(PersistentProgramStudent programStudent) throws PersistenceException;
    public abstract void handleProgramManager(PersistentProgramManager programManager) throws PersistenceException;
    public abstract void handleSimpleGradeSystem(PersistentSimpleGradeSystem simpleGradeSystem) throws PersistenceException;
    public abstract void handleProgram(PersistentProgram program) throws PersistenceException;
    public abstract void handleModuleWithUnitsStudent(PersistentModuleWithUnitsStudent moduleWithUnitsStudent) throws PersistenceException;
    public abstract void handleUnitSGroup(PersistentUnitSGroup unitSGroup) throws PersistenceException;
    public abstract void handleModuleGroupStudent(PersistentModuleGroupStudent moduleGroupStudent) throws PersistenceException;
    public abstract void handleStudentManager(PersistentStudentManager studentManager) throws PersistenceException;
    public abstract void handleStudent(PersistentStudent student) throws PersistenceException;
    public abstract void handleStudyGroupManager(PersistentStudyGroupManager studyGroupManager) throws PersistenceException;
    public abstract void handleUnitStudent(PersistentUnitStudent unitStudent) throws PersistenceException;
    public abstract void handleModuleWithUnitsSGroup(PersistentModuleWithUnitsSGroup moduleWithUnitsSGroup) throws PersistenceException;
    
}
