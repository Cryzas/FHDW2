
package model.visitor;

import persistence.*;

public interface ContaineeCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleDeleteCommand(DeleteCommand4Public deleteCommand) throws PersistenceException, E;
    
}
