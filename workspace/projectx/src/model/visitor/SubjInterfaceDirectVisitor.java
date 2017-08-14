
package model.visitor;

import persistence.*;

public abstract class SubjInterfaceDirectVisitor implements SubjInterfaceVisitor {
    
    public abstract void handleModuleAbstract(ModuleAbstract4Public moduleAbstract) throws PersistenceException;
    
    public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException{
        this.handleModuleAbstract(moduleAtomar);
    }
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.handleModuleAbstract(moduleWithUnits);
    }
    public abstract void handleProgram(Program4Public program) throws PersistenceException;
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
    public abstract void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException;
    
    public abstract void handleUnit(Unit4Public unit) throws PersistenceException;
    
    public abstract void handleSubj(Subj4Public subj) throws PersistenceException;
    
    public abstract void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException;
    
    
}
