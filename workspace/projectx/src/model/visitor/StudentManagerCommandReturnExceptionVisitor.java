
package model.visitor;
import persistence.*;

public interface StudentManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException, E;
    public R handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException, E;
    
}
