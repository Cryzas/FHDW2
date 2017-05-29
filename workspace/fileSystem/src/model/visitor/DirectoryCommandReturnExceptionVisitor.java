
package model.visitor;

import persistence.*;

public interface DirectoryCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException, E;
    
}
