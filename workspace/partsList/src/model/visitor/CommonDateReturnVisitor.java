
package model.visitor;
import persistence.*;

public interface CommonDateReturnVisitor<R> {
    
    public R handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException;
    public R handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException;
    public R handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
