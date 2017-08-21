
package model.visitor;
import persistence.*;

public interface CommonDateReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException, E;
    public R handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException, E;
    public R handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException, E;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    
}
