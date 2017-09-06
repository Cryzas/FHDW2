
package model.visitor;
import persistence.*;

public interface CommonDateVisitor {
    
    public void handleAddModuleToGroupCommand(AddModuleToGroupCommand4Public addModuleToGroupCommand) throws PersistenceException;
    public void handleAddModuleToProgCommand(AddModuleToProgCommand4Public addModuleToProgCommand) throws PersistenceException;
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException;
    public void handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException;
    public void handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException;
    public void handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException;
    public void handleChangeGradeOfModuleCommand(ChangeGradeOfModuleCommand4Public changeGradeOfModuleCommand) throws PersistenceException;
    public void handleChangeGradeOfUnitCommand(ChangeGradeOfUnitCommand4Public changeGradeOfUnitCommand) throws PersistenceException;
    public void handleChangeGradeSystemCommand(ChangeGradeSystemCommand4Public changeGradeSystemCommand) throws PersistenceException;
    public void handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException;
    public void handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException;
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException;
    public void handleStartStudyGroupCommand(StartStudyGroupCommand4Public startStudyGroupCommand) throws PersistenceException;
    public void handleSwapCPonModuleWithUnitsCommand(SwapCPonModuleWithUnitsCommand4Public swapCPonModuleWithUnitsCommand) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
