
package model.visitor;

import persistence.*;

public abstract class DirectoryCommandStandardVisitor implements DirectoryCommandVisitor {
    
    public void handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException{
        this.standardHandling(addContaineeCommand);
    }
    protected abstract void standardHandling(DirectoryCommand directoryCommand) throws PersistenceException;
}
