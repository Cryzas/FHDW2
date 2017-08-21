
package model.visitor;
import persistence.*;

public interface PartsListManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException, E;
    public R handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException, E;
    
}
