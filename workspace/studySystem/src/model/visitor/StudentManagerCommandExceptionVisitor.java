
package model.visitor;
import persistence.*;

public interface StudentManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleChangeGradeCommand(ChangeGradeCommand4Public changeGradeCommand) throws PersistenceException, E;
    
}
