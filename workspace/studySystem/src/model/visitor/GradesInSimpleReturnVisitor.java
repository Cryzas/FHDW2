
package model.visitor;
import persistence.*;

public interface GradesInSimpleReturnVisitor<R> {
    
    public R handleNotPassed(NotPassed4Public notPassed) throws PersistenceException;
    public R handlePassed(Passed4Public passed) throws PersistenceException;
    
}
