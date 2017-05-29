
package model.visitor;

import persistence.*;

public interface ContaineeCommandVisitor {
    
    public void handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException;
    
}
