
package model.visitor;
import persistence.*;

public interface GradeSystemReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGradeSystem) throws PersistenceException, E;
    public R handleThirdGradeSystem(ThirdGradeSystem4Public thirdGradeSystem) throws PersistenceException, E;
    
}
