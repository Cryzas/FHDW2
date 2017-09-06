
package model.visitor;
import persistence.*;

public interface StudentManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException, E;
    public void handleChangeGradeOfModuleSimpleCommand(ChangeGradeOfModuleSimpleCommand4Public changeGradeOfModuleSimpleCommand) throws PersistenceException, E;
    public void handleChangeGradeOfModuleThirdCommand(ChangeGradeOfModuleThirdCommand4Public changeGradeOfModuleThirdCommand) throws PersistenceException, E;
    public void handleChangeGradeOfUnitCommand(ChangeGradeOfUnitCommand4Public changeGradeOfUnitCommand) throws PersistenceException, E;
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException, E;
    
}
