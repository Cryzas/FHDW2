
package model.visitor;
import persistence.*;

public interface GradesInSimpleExceptionVisitor<E extends model.UserException> {
    
    public void handleNoGradeSimple(NoGradeSimple4Public noGradeSimple) throws PersistenceException, E;
    public void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException, E;
    public void handlePassed(Passed4Public passed) throws PersistenceException, E;
    
}
