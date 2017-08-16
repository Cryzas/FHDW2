
package view.visitor;
import view.*;

public interface AnythingReturnVisitor<R> extends ModuleAbstractReturnVisitor<R> ,ModuleAbstractSGroupReturnVisitor<R> {
    
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleModuleManager(ModuleManagerView moduleManager) throws ModelException;
    public R handleProgram(ProgramView program) throws ModelException;
    public R handleProgramManager(ProgramManagerView programManager) throws ModelException;
    public R handleProgramSGroup(ProgramSGroupView programSGroup) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleStudyGroup(StudyGroupView studyGroup) throws ModelException;
    public R handleUnit(UnitView unit) throws ModelException;
    public R handleUnitSGroup(UnitSGroupView unitSGroup) throws ModelException;
    
}
