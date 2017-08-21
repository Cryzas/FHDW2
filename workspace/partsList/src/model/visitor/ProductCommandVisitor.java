
package model.visitor;
import persistence.*;

public interface ProductCommandVisitor {
    
    public void handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException;
    
}
