
package model.visitor;

import persistence.*;

public interface ProductCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException, E;
    
}
