
package model.visitor;

import persistence.*;

public interface DirectoryCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException, E;
    
}
