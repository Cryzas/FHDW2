
package view.visitor;
import view.*;

public interface GradeSystemVisitor {
    
    public void handleSimpleGrade(SimpleGradeView simpleGrade) throws ModelException;
    public void handleTenthGrade(TenthGradeView tenthGrade) throws ModelException;
    public void handleThirdGrade(ThirdGradeView thirdGrade) throws ModelException;
    
}
