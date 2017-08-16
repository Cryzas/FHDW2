
package view.visitor;
import view.*;

public interface AnythingVisitor extends ModuleAbstractVisitor,ModuleAbstractSGroupVisitor{
    
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleModuleManager(ModuleManagerView moduleManager) throws ModelException;
    public void handleProgram(ProgramView program) throws ModelException;
    public void handleProgramManager(ProgramManagerView programManager) throws ModelException;
    public void handleProgramSGroup(ProgramSGroupView programSGroup) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleStudyGroup(StudyGroupView studyGroup) throws ModelException;
    public void handleStudyGroupManager(StudyGroupManagerView studyGroupManager) throws ModelException;
    public void handleUnit(UnitView unit) throws ModelException;
    public void handleUnitSGroup(UnitSGroupView unitSGroup) throws ModelException;
    
}
