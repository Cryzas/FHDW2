
package model.visitor;

import persistence.*;

public abstract class StudentManagerCommandStandardVisitor implements StudentManagerCommandVisitor {
    
    public void handleChangeGradeCommand(ChangeGradeCommand4Public changeGradeCommand) throws PersistenceException{
        this.standardHandling(changeGradeCommand);
    }
    protected abstract void standardHandling(StudentManagerCommand studentManagerCommand) throws PersistenceException;
}
