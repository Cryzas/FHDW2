
package model.visitor;

import persistence.*;

public interface CommonDateExceptionVisitor<E extends model.UserException> {
    
    public void handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException, E;
    public void handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException, E;
    public void handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    
}
