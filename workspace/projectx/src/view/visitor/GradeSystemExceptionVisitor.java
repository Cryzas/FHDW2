
package view.visitor;
import view.*;

public interface GradeSystemExceptionVisitor<E extends view.UserException> {
    
    public void handleSimpleGrade(SimpleGradeView simpleGrade) throws ModelException, E;
    public void handleTenthGrade(TenthGradeView tenthGrade) throws ModelException, E;
    public void handleThirdGrade(ThirdGradeView thirdGrade) throws ModelException, E;
    
}
