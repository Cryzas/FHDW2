
package model.visitor;
import persistence.*;

public interface CommonDateVisitor {
    
    public void handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException;
    public void handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException;
    public void handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
