
package model.visitor;

import persistence.*;

public abstract class StudentManagerCommandStandardVisitor implements StudentManagerCommandVisitor {
    
    public void handleCreateStudentCommand(CreateStudentCommand4Public createStudentCommand) throws PersistenceException{
        this.standardHandling(createStudentCommand);
    }
    public void handleAddStudentToGroupCommand(AddStudentToGroupCommand4Public addStudentToGroupCommand) throws PersistenceException{
        this.standardHandling(addStudentToGroupCommand);
    }
    public void handleChangeGradeCommand(ChangeGradeCommand4Public changeGradeCommand) throws PersistenceException{
        this.standardHandling(changeGradeCommand);
    }
    protected abstract void standardHandling(StudentManagerCommand studentManagerCommand) throws PersistenceException;
}
