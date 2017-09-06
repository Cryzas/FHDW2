
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException{
        this.standardHandling(createProgramCommand);
    }
    public void handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException{
        this.standardHandling(changeCPOnModuleCommand);
    }
    public void handleChangeGradeOfUnitCommand(ChangeGradeOfUnitCommand4Public changeGradeOfUnitCommand) throws PersistenceException{
        this.standardHandling(changeGradeOfUnitCommand);
    }
    public void handleChangeGradeSystemCommand(ChangeGradeSystemCommand4Public changeGradeSystemCommand) throws PersistenceException{
        this.standardHandling(changeGradeSystemCommand);
    }
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException{
        this.standardHandling(createStudentCommand);
    }
    public void handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException{
        this.standardHandling(swapCPonModuleWithUnitsCommand);
    }
    public void handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException{
        this.standardHandling(changeCPOnUnitCommand);
    }
    public void handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException{
        this.standardHandling(startStudyGroupCommand);
    }
    public void handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException{
        this.standardHandling(createModuleCommand);
    }
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException{
        this.standardHandling(addStudentToGroupCommand);
    }
    public void handleAddModuleToGroupCommand(AddModuleToGroupCommand4Public addModuleToGroupCommand) throws PersistenceException{
        this.standardHandling(addModuleToGroupCommand);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleChangeGradeOfModuleCommand(ChangeGradeOfModuleCommand4Public changeGradeOfModuleCommand) throws PersistenceException{
        this.standardHandling(changeGradeOfModuleCommand);
    }
    public void handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException{
        this.standardHandling(addModuleToProgCommand);
    }
    public void handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException{
        this.standardHandling(addUnitCommand);
    }
    protected abstract void standardHandling(CommonDate4Public commonDate) throws PersistenceException;
}
