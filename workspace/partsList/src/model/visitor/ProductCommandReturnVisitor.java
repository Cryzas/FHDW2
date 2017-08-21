
package model.visitor;
import persistence.*;

public interface ProductCommandReturnVisitor<R> {
    
    public R handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException;
    
}
