
package view.visitor;

import view.*;

public abstract class GradesInSimpleStandardVisitor implements GradesInSimpleVisitor {
    
    public void handlePassed(PassedView passed) throws ModelException{
        this.standardHandling(passed);
    }
    public void handleNoGradeSimple(NoGradeSimpleView noGradeSimple) throws ModelException{
        this.standardHandling(noGradeSimple);
    }
    public void handleNotPassed(NotPassedView notPassed) throws ModelException{
        this.standardHandling(notPassed);
    }
    protected abstract void standardHandling(GradesInSimpleView gradesInSimple) throws ModelException;
}
