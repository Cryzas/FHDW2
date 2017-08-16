
package model.visitor;

import persistence.*;

public abstract class ProgramManagerCommandStandardVisitor implements ProgramManagerCommandVisitor {
    
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException{
        this.standardHandling(createProgramCommand);
    }
    public void handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException{
        this.standardHandling(startStudyGroupCommand);
    }
    public void handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException{
        this.standardHandling(addModuleToProgCommand);
    }
    protected abstract void standardHandling(ProgramManagerCommand programManagerCommand) throws PersistenceException;
}
