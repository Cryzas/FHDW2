
package model.visitor;
import persistence.*;

public interface StudentManagerCommandReturnVisitor<R> {
    
    public R handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException;
    public R handleChangeGradeOfModuleSimpleCommand(ChangeGradeOfModuleSimpleCommand4Public changeGradeOfModuleSimpleCommand) throws PersistenceException;
    public R handleChangeGradeOfModuleThirdCommand(ChangeGradeOfModuleThirdCommand4Public changeGradeOfModuleThirdCommand) throws PersistenceException;
    public R handleChangeGradeOfUnitCommand(ChangeGradeOfUnitCommand4Public changeGradeOfUnitCommand) throws PersistenceException;
    public R handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException;
    
}
