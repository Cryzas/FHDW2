
package model.visitor;
import persistence.*;

public interface SubjInterfaceReturnExceptionVisitor<R, E extends model.UserException> extends ModuleAbstractReturnExceptionVisitor<R, E> {
    
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public R handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException, E;
    public R handleProgram(Program4Public program) throws PersistenceException, E;
    public R handleProgramManager(ProgramManager4Public programManager) throws PersistenceException, E;
    public R handleServer(Server4Public server) throws PersistenceException, E;
    public R handleSubj(Subj4Public subj) throws PersistenceException, E;
    public R handleUnit(Unit4Public unit) throws PersistenceException, E;
    
}
