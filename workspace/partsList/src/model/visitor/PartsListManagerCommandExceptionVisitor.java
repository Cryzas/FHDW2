
package model.visitor;
import persistence.*;

public interface PartsListManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException, E;
    public void handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException, E;
    
}
