
package model.visitor;
import persistence.*;

public interface GradeSystemExceptionVisitor<E extends model.UserException> {
    
    public void handleSimpleGrade(SimpleGrade4Public simpleGrade) throws PersistenceException, E;
    public void handleTenthGrade(TenthGrade4Public tenthGrade) throws PersistenceException, E;
    public void handleThirdGrade(ThirdGrade4Public thirdGrade) throws PersistenceException, E;
    
}
