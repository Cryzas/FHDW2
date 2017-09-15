
package view.visitor;
import view.*;

public interface GradeSystemReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleSimpleGradeSystem(SimpleGradeSystemView simpleGradeSystem) throws ModelException, E;
    public R handleThirdGradeSystem(ThirdGradeSystemView thirdGradeSystem) throws ModelException, E;
    
}
