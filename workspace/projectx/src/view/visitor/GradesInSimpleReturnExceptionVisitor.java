
package view.visitor;
import view.*;

public interface GradesInSimpleReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleNoGradeSimple(NoGradeSimpleView noGradeSimple) throws ModelException, E;
    public R handleNotPassed(NotPassedView notPassed) throws ModelException, E;
    public R handlePassed(PassedView passed) throws ModelException, E;
    
}
