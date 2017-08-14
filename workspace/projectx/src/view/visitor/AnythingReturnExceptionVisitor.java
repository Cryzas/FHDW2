
package view.visitor;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends ModuleAbstractReturnExceptionVisitor<R, E> {
    
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleModuleManager(ModuleManagerView moduleManager) throws ModelException, E;
    public R handleProgram(ProgramView program) throws ModelException, E;
    public R handleProgramManager(ProgramManagerView programManager) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleUnit(UnitView unit) throws ModelException, E;
    
}
