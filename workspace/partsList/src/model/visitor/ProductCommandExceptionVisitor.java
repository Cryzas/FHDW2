
package model.visitor;

import persistence.*;

public interface ProductCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException, E;
    
}
