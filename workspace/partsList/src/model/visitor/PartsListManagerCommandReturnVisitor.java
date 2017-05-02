
package model.visitor;

import persistence.*;

public interface PartsListManagerCommandReturnVisitor<R> {
    
    public R handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException;
    public R handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException;
    
}
