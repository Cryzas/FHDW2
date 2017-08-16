
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
    
    public abstract void handleModuleManager(ModuleManagerView moduleManager) throws ModelException;
    
    public abstract void handleUnit(UnitView unit) throws ModelException;
    
    public abstract void handleStudyGroup(StudyGroupView studyGroup) throws ModelException;
    
    public abstract void handleProgramManager(ProgramManagerView programManager) throws ModelException;
    
    
}