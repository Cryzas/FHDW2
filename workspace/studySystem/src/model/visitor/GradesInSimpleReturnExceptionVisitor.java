
package model.visitor;
import persistence.*;

public interface GradesInSimpleReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleNotPassed(NotPassed4Public notPassed) throws PersistenceException, E;
    public R handlePassed(Passed4Public passed) throws PersistenceException, E;
    
}
