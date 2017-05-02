
package model.visitor;

import persistence.*;

public abstract class PartsListManagerCommandStandardVisitor implements PartsListManagerCommandVisitor {
    
    public void handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException{
        this.standardHandling(createMaterialCommand);
    }
    public void handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException{
        this.standardHandling(createProductCommand);
    }
    protected abstract void standardHandling(PartsListManagerCommand partsListManagerCommand) throws PersistenceException;
}
