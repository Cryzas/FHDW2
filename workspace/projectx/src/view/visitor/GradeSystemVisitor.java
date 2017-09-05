
package view.visitor;
import view.*;

public interface GradeSystemVisitor {
    
    public void handleSimpleGradeSystem(SimpleGradeSystemView simpleGradeSystem) throws ModelException;
    public void handleThirdGradeSystem(ThirdGradeSystemView thirdGradeSystem) throws ModelException;
    
}
