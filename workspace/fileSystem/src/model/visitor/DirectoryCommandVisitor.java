
package model.visitor;

import persistence.*;

public interface DirectoryCommandVisitor {
    
    public void handleAddContaineeCommand(AddContaineeCommand4Public addContaineeCommand) throws PersistenceException;
    
}
