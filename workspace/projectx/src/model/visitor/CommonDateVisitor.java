
package model.visitor;
import persistence.*;

public interface CommonDateVisitor {
    
    public void handleAddModuleCommand(AddModuleCommand4Public addModuleCommand) throws PersistenceException;
    public void handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException;
    public void handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException;
    public void handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException;
    public void handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException;
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
