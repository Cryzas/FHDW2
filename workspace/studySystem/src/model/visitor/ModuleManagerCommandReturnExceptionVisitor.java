
package model.visitor;
import persistence.*;

public interface ModuleManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddModuleToGroupCommand(AddModuleToGroupCommand4Public addModuleToGroupCommand) throws PersistenceException, E;
    public R handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException, E;
    public R handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException, E;
    public R handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException, E;
    public R handleChangeGradeSystemCommand(ChangeGradeSystemCommand4Public changeGradeSystemCommand) throws PersistenceException, E;
    public R handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException, E;
    
}
