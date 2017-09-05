
package view.visitor;
import view.*;

public interface GradesInSimpleVisitor {
    
    public void handleNoGradeSimple(NoGradeSimpleView noGradeSimple) throws ModelException;
    public void handleNotPassed(NotPassedView notPassed) throws ModelException;
    public void handlePassed(PassedView passed) throws ModelException;
    
}
