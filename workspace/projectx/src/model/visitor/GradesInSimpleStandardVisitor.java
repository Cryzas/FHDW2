
package model.visitor;

import persistence.*;

public abstract class GradesInSimpleStandardVisitor implements GradesInSimpleVisitor {
    
    public void handlePassed(Passed4Public passed) throws PersistenceException{
        this.standardHandling(passed);
    }
    public void handleNoGradeSimple(NoGradeSimple4Public noGradeSimple) throws PersistenceException{
        this.standardHandling(noGradeSimple);
    }
    public void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException{
        this.standardHandling(notPassed);
    }
    protected abstract void standardHandling(GradesInSimple4Public gradesInSimple) throws PersistenceException;
}
