
package model.visitor;

import persistence.*;

public abstract class ProductCommandStandardVisitor implements ProductCommandVisitor {
    
    public void handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException{
        this.standardHandling(addPartCommand);
    }
    protected abstract void standardHandling(ProductCommand productCommand) throws PersistenceException;
}
