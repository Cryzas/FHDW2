
package model.visitor;

import persistence.*;

public abstract class CommandStandardVisitor implements CommandVisitor {
    
    public void handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException{
        this.standardHandling(deleteCommand);
    }
    public void handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException{
        this.standardHandling(addContaineeCommand);
    }
    public void handleChangeContentsCommand(ChangeContentsCommand4Public changeContentsCommand) throws PersistenceException{
        this.standardHandling(changeContentsCommand);
    }
    protected abstract void standardHandling(Command command) throws PersistenceException;
}
