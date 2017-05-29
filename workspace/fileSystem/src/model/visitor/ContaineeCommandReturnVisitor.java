
package model.visitor;

import persistence.*;

public interface ContaineeCommandReturnVisitor<R> {
    
    public R handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException;
    
}
