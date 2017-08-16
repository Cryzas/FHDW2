
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleProgramSGroup(ProgramSGroup4Public programSGroup) throws PersistenceException;
    public abstract void handleModuleGroupSGroup(ModuleGroupSGroup4Public moduleGroupSGroup) throws PersistenceException;
    public abstract void handleModuleAtomarSGroup(ModuleAtomarSGroup4Public moduleAtomarSGroup) throws PersistenceException;
    public abstract void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException;
    public abstract void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException;
    public abstract void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    public abstract void handleUnit(Unit4Public unit) throws PersistenceException;
    public abstract void handleStudyGroup(StudyGroup4Public studyGroup) throws PersistenceException;
    public abstract void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException;
    public abstract void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    public abstract void handleProgram(Program4Public program) throws PersistenceException;
    public abstract void handleUnitSGroup(UnitSGroup4Public unitSGroup) throws PersistenceException;
    public abstract void handleStudyGroupManager(StudyGroupManager4Public studyGroupManager) throws PersistenceException;
    public abstract void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroup4Public moduleWithUnitsSGroup) throws PersistenceException;
    
}
