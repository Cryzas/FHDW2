
package model.visitor;
import persistence.*;

public interface StudentManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException, E;
    public R handleChangeGradeOfModuleCommand(ChangeGradeOfModuleCommand4Public changeGradeOfModuleCommand) throws PersistenceException, E;
    public R handleChangeGradeOfUnitCommand(ChangeGradeOfUnitCommand4Public changeGradeOfUnitCommand) throws PersistenceException, E;
    public R handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException, E;
    
}
