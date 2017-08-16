
package view.visitor;
import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> extends ModuleAbstractExceptionVisitor<E>,ModuleAbstractSGroupExceptionVisitor<E>{
    
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleModuleManager(ModuleManagerView moduleManager) throws ModelException, E;
    public void handleProgram(ProgramView program) throws ModelException, E;
    public void handleProgramManager(ProgramManagerView programManager) throws ModelException, E;
    public void handleProgramSGroup(ProgramSGroupView programSGroup) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleStudyGroup(StudyGroupView studyGroup) throws ModelException, E;
    public void handleUnit(UnitView unit) throws ModelException, E;
    public void handleUnitSGroup(UnitSGroupView unitSGroup) throws ModelException, E;
    
}
