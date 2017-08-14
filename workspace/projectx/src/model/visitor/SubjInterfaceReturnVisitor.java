
package model.visitor;
import persistence.*;

public interface SubjInterfaceReturnVisitor<R> extends ModuleAbstractReturnVisitor<R> {
    
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public R handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    public R handleProgram(Program4Public program) throws PersistenceException;
    public R handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    public R handleSubj(Subj4Public subj) throws PersistenceException;
    public R handleUnit(Unit4Public unit) throws PersistenceException;
    
}
