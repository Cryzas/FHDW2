
package model.visitor;
import persistence.*;

public interface StudentManagerCommandReturnVisitor<R> {
    
    public R handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException;
    public R handleChangeGradeCommand(ChangeGradeCommand4Public changeGradeCommand) throws PersistenceException;
    public R handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException;
    
}
