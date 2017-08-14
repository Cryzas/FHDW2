
package model.visitor;
import persistence.*;

public interface SubjInterfaceExceptionVisitor<E extends model.UserException> extends ModuleAbstractExceptionVisitor<E>{
    
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException, E;
    public void handleProgram(Program4Public program) throws PersistenceException, E;
    public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    public void handleSubj(Subj4Public subj) throws PersistenceException, E;
    public void handleUnit(Unit4Public unit) throws PersistenceException, E;
    
}
