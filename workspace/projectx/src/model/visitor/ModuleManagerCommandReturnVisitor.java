
package model.visitor;
import persistence.*;

public interface ModuleManagerCommandReturnVisitor<R> {
    
    public R handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException;
    public R handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException;
    public R handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException;
    public R handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException;
    
}
