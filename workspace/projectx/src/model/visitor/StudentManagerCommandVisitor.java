
package model.visitor;
import persistence.*;

public interface StudentManagerCommandVisitor {
    
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException;
    public void handleChangeGradeOfModuleSimpleCommand(ChangeGradeOfModuleSimpleCommand4Public changeGradeOfModuleSimpleCommand) throws PersistenceException;
    public void handleChangeGradeOfModuleThirdCommand(ChangeGradeOfModuleThirdCommand4Public changeGradeOfModuleThirdCommand) throws PersistenceException;
    public void handleChangeGradeOfUnitCommand(ChangeGradeOfUnitCommand4Public changeGradeOfUnitCommand) throws PersistenceException;
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException;
    
}
