
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException{
        this.standardHandling(createProgramCommand);
    }
    public void handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException{
        this.standardHandling(changeCPOnModuleCommand);
    }
    public void handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException{
        this.standardHandling(changeCPOnUnitCommand);
    }
    public void handleAddModuleToGroupCommand(AddModuleToGroupCommand4Public addModuleToGroupCommand) throws PersistenceException{
        this.standardHandling(addModuleToGroupCommand);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException{
        this.standardHandling(createModuleCommand);
    }
    public void handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException{
        this.standardHandling(addModuleToProgCommand);
    }
    public void handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException{
        this.standardHandling(addUnitCommand);
    }
    protected abstract void standardHandling(CommonDate4Public commonDate) throws PersistenceException;
}
