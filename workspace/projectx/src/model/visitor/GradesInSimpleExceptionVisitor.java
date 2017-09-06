
package model.visitor;
import persistence.*;

public interface GradesInSimpleExceptionVisitor<E extends model.UserException> {
    
    public void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException, E;
    public void handlePassed(Passed4Public passed) throws PersistenceException, E;
    
}
