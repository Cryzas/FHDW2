
package model.visitor;

import persistence.*;

public abstract class StudentManagerCommandStandardVisitor implements StudentManagerCommandVisitor {
    
    public void handleChangeGradeOfUnitCommand(ChangeGradeOfUnitCommand4Public changeGradeOfUnitCommand) throws PersistenceException{
        this.standardHandling(changeGradeOfUnitCommand);
    }
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException{
        this.standardHandling(createStudentCommand);
    }
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException{
        this.standardHandling(addStudentToGroupCommand);
    }
    public void handleChangeGradeOfModuleCommand(ChangeGradeOfModuleCommand4Public changeGradeOfModuleCommand) throws PersistenceException{
        this.standardHandling(changeGradeOfModuleCommand);
    }
    protected abstract void standardHandling(StudentManagerCommand studentManagerCommand) throws PersistenceException;
}
