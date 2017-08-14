
package model.visitor;
import persistence.*;

public interface CommonDateReturnVisitor<R> {
    
    public R handleAddModuleCommand(AddModuleCommand4Public addModuleCommand) throws PersistenceException;
    public R handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException;
    public R handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException;
    public R handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException;
    public R handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException;
    public R handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
