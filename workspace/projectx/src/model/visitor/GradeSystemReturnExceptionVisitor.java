
package model.visitor;
import persistence.*;

public interface GradeSystemReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleSimpleGrade(SimpleGrade4Public simpleGrade) throws PersistenceException, E;
    public R handleTenthGrade(TenthGrade4Public tenthGrade) throws PersistenceException, E;
    public R handleThirdGrade(ThirdGrade4Public thirdGrade) throws PersistenceException, E;
    
}
