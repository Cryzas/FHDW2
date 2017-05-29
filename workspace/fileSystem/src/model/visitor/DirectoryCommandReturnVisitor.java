
package model.visitor;

import persistence.*;

public interface DirectoryCommandReturnVisitor<R> {
    
    public R handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException;
    
}
