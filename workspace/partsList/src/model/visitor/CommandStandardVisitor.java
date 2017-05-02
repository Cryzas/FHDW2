
package model.visitor;

import persistence.*;

public abstract class CommandStandardVisitor implements CommandVisitor {
    
    public void handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException{
        this.standardHandling(createMaterialCommand);
    }
    public void handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException{
        this.standardHandling(addPartCommand);
    }
    public void handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException{
        this.standardHandling(createProductCommand);
    }
    protected abstract void standardHandling(Command command) throws PersistenceException;
}
