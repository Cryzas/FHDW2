
package view.visitor;
import view.*;

public interface GradeSystemReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleSimpleGrade(SimpleGradeView simpleGrade) throws ModelException, E;
    public R handleTenthGrade(TenthGradeView tenthGrade) throws ModelException, E;
    public R handleThirdGrade(ThirdGradeView thirdGrade) throws ModelException, E;
    
}
