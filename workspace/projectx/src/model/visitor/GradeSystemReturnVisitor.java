
package model.visitor;
import persistence.*;

public interface GradeSystemReturnVisitor<R> {
    
    public R handleSimpleGrade(SimpleGrade4Public simpleGrade) throws PersistenceException;
    public R handleTenthGrade(TenthGrade4Public tenthGrade) throws PersistenceException;
    public R handleThirdGrade(ThirdGrade4Public thirdGrade) throws PersistenceException;
    
}
