
package model.visitor;
import persistence.*;

public interface StudentManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException, E;
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException, E;
    
}
