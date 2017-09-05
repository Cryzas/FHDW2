
package view.visitor;
import view.*;

public interface GradeSystemReturnVisitor<R> {
    
    public R handleSimpleGradeSystem(SimpleGradeSystemView simpleGradeSystem) throws ModelException;
    public R handleThirdGradeSystem(ThirdGradeSystemView thirdGradeSystem) throws ModelException;
    
}
