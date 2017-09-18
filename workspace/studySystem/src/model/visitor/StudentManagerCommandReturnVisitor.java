
package model.visitor;
import persistence.*;

public interface StudentManagerCommandReturnVisitor<R> {
    
    public R handleChangeGradeCommand(ChangeGradeCommand4Public changeGradeCommand) throws PersistenceException;
    
}
