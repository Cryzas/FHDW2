
package view.visitor;
import view.*;

public interface GradeSystemExceptionVisitor<E extends view.UserException> {
    
    public void handleSimpleGradeSystem(SimpleGradeSystemView simpleGradeSystem) throws ModelException, E;
    public void handleThirdGradeSystem(ThirdGradeSystemView thirdGradeSystem) throws ModelException, E;
    
}
