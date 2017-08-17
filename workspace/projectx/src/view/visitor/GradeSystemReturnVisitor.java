
package view.visitor;
import view.*;

public interface GradeSystemReturnVisitor<R> {
    
    public R handleSimpleGrade(SimpleGradeView simpleGrade) throws ModelException;
    public R handleTenthGrade(TenthGradeView tenthGrade) throws ModelException;
    public R handleThirdGrade(ThirdGradeView thirdGrade) throws ModelException;
    
}
