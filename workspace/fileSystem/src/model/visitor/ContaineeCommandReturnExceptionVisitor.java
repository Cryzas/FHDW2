
package model.visitor;

import persistence.*;

public interface ContaineeCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException, E;
    
}
