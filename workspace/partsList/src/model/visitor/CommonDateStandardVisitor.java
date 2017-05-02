
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException{
        this.standardHandling(createMaterialCommand);
    }
    public void handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException{
        this.standardHandling(addPartCommand);
    }
    public void handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException{
        this.standardHandling(createProductCommand);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    protected abstract void standardHandling(CommonDate4Public commonDate) throws PersistenceException;
}
