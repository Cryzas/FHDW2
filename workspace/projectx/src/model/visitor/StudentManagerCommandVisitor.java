
package model.visitor;
import persistence.*;

public interface StudentManagerCommandVisitor {
    
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException;
    public void handleChangeGradeOfModuleCommand(ChangeGradeOfModuleCommand4Public changeGradeOfModuleCommand) throws PersistenceException;
    public void handleChangeGradeOfUnitCommand(ChangeGradeOfUnitCommand4Public changeGradeOfUnitCommand) throws PersistenceException;
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException;
    
}
