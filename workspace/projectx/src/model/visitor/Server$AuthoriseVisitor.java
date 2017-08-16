
package model.visitor;

import persistence.*;

public abstract class Server$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleProgram(PersistentProgram program) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleModuleAtomar(PersistentModuleAtomar moduleAtomar) throws PersistenceException;
    public abstract void handleModuleWithUnits(PersistentModuleWithUnits moduleWithUnits) throws PersistenceException;
    public abstract void handleUnit(PersistentUnit unit) throws PersistenceException;
    public abstract void handleModuleGroup(PersistentModuleGroup moduleGroup) throws PersistenceException;
    public abstract void handleModuleManager(PersistentModuleManager moduleManager) throws PersistenceException;
    public abstract void handleProgramManager(PersistentProgramManager programManager) throws PersistenceException;
    
}
