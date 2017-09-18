
package model.visitor;
import persistence.*;

public interface StudentManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleChangeGradeCommand(ChangeGradeCommand4Public changeGradeCommand) throws PersistenceException, E;
    
}
