
package model.visitor;

import persistence.*;

public interface PartsListManagerCommandVisitor {
    
    public void handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException;
    public void handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException;
    
}
