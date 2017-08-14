
package model.visitor;
import persistence.*;

public interface SubjInterfaceVisitor extends ModuleAbstractVisitor{
    
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    public void handleProgram(Program4Public program) throws PersistenceException;
    public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    public void handleSubj(Subj4Public subj) throws PersistenceException;
    public void handleUnit(Unit4Public unit) throws PersistenceException;
    
}
