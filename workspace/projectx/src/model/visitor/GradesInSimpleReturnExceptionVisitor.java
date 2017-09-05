
package model.visitor;
import persistence.*;

public interface GradesInSimpleReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleNoGradeSimple(NoGradeSimple4Public noGradeSimple) throws PersistenceException, E;
    public R handleNotPassed(NotPassed4Public notPassed) throws PersistenceException, E;
    public R handlePassed(Passed4Public passed) throws PersistenceException, E;
    
}
