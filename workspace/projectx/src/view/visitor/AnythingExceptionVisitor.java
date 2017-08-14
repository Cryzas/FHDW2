
package view.visitor;
import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> extends ModuleAbstractExceptionVisitor<E>{
    
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleModuleManager(ModuleManagerView moduleManager) throws ModelException, E;
    public void handleProgram(ProgramView program) throws ModelException, E;
    public void handleProgramManager(ProgramManagerView programManager) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleUnit(UnitView unit) throws ModelException, E;
    
}
