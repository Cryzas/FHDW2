
package model.visitor;
import persistence.*;

public interface GradesInSimpleReturnVisitor<R> {
    
    public R handleNoGradeSimple(NoGradeSimple4Public noGradeSimple) throws PersistenceException;
    public R handleNotPassed(NotPassed4Public notPassed) throws PersistenceException;
    public R handlePassed(Passed4Public passed) throws PersistenceException;
    
}
