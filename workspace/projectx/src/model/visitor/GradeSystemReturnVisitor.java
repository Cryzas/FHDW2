
package model.visitor;
import persistence.*;

public interface GradeSystemReturnVisitor<R> {
    
    public R handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGradeSystem) throws PersistenceException;
    public R handleThirdGradeSystem(ThirdGradeSystem4Public thirdGradeSystem) throws PersistenceException;
    
}
