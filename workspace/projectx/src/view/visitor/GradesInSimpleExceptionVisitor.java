
package view.visitor;
import view.*;

public interface GradesInSimpleExceptionVisitor<E extends view.UserException> {
    
    public void handleNoGradeSimple(NoGradeSimpleView noGradeSimple) throws ModelException, E;
    public void handleNotPassed(NotPassedView notPassed) throws ModelException, E;
    public void handlePassed(PassedView passed) throws ModelException, E;
    
}
