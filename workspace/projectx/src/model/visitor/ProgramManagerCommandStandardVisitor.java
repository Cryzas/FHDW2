
package model.visitor;

import persistence.*;

public abstract class ProgramManagerCommandStandardVisitor implements ProgramManagerCommandVisitor {
    
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException{
        this.standardHandling(createProgramCommand);
    }
    public void handleAddModuleCommand(AddModuleCommand4Public addModuleCommand) throws PersistenceException{
        this.standardHandling(addModuleCommand);
    }
    protected abstract void standardHandling(ProgramManagerCommand programManagerCommand) throws PersistenceException;
}
