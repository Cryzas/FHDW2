
package model.visitor;

import persistence.*;

public abstract class ContaineeCommandStandardVisitor implements ContaineeCommandVisitor {
    
    public void handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException{
        this.standardHandling(deleteCommand);
    }
    protected abstract void standardHandling(ContaineeCommand containeeCommand) throws PersistenceException;
}
