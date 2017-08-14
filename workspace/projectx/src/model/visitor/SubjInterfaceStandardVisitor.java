
package model.visitor;

import persistence.*;

public abstract class SubjInterfaceStandardVisitor implements SubjInterfaceVisitor {
    
    public void handleProgram(Program4Public program) throws PersistenceException{
        this.standardHandling(program);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleModuleAtomar(ModuleAtomar4Public moduleAtomar) throws PersistenceException{
        this.standardHandling(moduleAtomar);
    }
    public void handleModuleWithUnits(ModuleWithUnits4Public moduleWithUnits) throws PersistenceException{
        this.standardHandling(moduleWithUnits);
    }
    public void handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException{
        this.standardHandling(moduleManager);
    }
    public void handleUnit(Unit4Public unit) throws PersistenceException{
        this.standardHandling(unit);
    }
    public void handleSubj(Subj4Public subj) throws PersistenceException{
        this.standardHandling(subj);
    }
    public void handleProgramManager(ProgramManager4Public programManager) throws PersistenceException{
        this.standardHandling(programManager);
    }
    protected abstract void standardHandling(SubjInterface subjInterface) throws PersistenceException;
}
