
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleProgram(Program4Public program) throws PersistenceException;
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException;
    public abstract void handleModuleGroup(ModuleGroup4Public moduleGroup) throws PersistenceException;
    public abstract void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    public abstract void handleUnit(Unit4Public unit) throws PersistenceException;
    public abstract void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException;
    public abstract void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    
}
