
package model.visitor;
import persistence.*;

public interface GradeSystemVisitor {
    
    public void handleSimpleGrade(SimpleGrade4Public simpleGrade) throws PersistenceException;
    public void handleTenthGrade(TenthGrade4Public tenthGrade) throws PersistenceException;
    public void handleThirdGrade(ThirdGrade4Public thirdGrade) throws PersistenceException;
    
}
