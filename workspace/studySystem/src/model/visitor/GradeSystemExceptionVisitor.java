
package model.visitor;
import persistence.*;

public interface GradeSystemExceptionVisitor<E extends model.UserException> {
    
    public void handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGradeSystem) throws PersistenceException, E;
    public void handleThirdGradeSystem(ThirdGradeSystem4Public thirdGradeSystem) throws PersistenceException, E;
    
}
