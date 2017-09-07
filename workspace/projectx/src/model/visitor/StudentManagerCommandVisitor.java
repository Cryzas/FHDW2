
package model.visitor;
import persistence.*;

public interface StudentManagerCommandVisitor {
    
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException;
    public void handleChangeGradeCommand(ChangeGradeCommand4Public changeGradeCommand) throws PersistenceException;
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException;
    
}
