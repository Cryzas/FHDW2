
package view.visitor;
import view.*;

public interface GradesInSimpleReturnVisitor<R> {
    
    public R handleNoGradeSimple(NoGradeSimpleView noGradeSimple) throws ModelException;
    public R handleNotPassed(NotPassedView notPassed) throws ModelException;
    public R handlePassed(PassedView passed) throws ModelException;
    
}
