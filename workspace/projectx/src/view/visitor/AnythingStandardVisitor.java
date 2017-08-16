
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
    public void handleModuleWithUnits(ModuleWithUnitsView moduleWithUnits) throws ModelException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleProgramManager(ProgramManagerView programManager) throws ModelException{
        this.standardHandling(programManager);
    }
    public void handleProgram(ProgramView program) throws ModelException{
        this.standardHandling(program);
    }
    public void handleUnitSGroup(UnitSGroupView unitSGroup) throws ModelException{
        this.standardHandling(unitSGroup);
    }
    public void handleModuleWithUnitsSGroup(ModuleWithUnitsSGroupView moduleWithUnitsSGroup) throws ModelException{
        this.standardHandling(moduleWithUnitsSGroup);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
