
package model.visitor;
import persistence.*;

public interface StudentManagerCommandVisitor {
    
    public void handleChangeGradeCommand(ChangeGradeCommand4Public changeGradeCommand) throws PersistenceException;
    
}
