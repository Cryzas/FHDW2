
package model.visitor;
import persistence.*;

public interface GradeSystemVisitor {
    
    public void handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGradeSystem) throws PersistenceException;
    public void handleThirdGradeSystem(ThirdGradeSystem4Public thirdGradeSystem) throws PersistenceException;
    
}
