
package view.visitor;
import view.*;

public interface AnythingVisitor extends ModuleAbstractVisitor{
    
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleModuleManager(ModuleManagerView moduleManager) throws ModelException;
    public void handleProgram(ProgramView program) throws ModelException;
    public void handleProgramManager(ProgramManagerView programManager) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleUnit(UnitView unit) throws ModelException;
    
}
