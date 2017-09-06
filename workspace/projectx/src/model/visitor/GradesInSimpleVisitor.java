
package model.visitor;
import persistence.*;

public interface GradesInSimpleVisitor {
    
    public void handleNotPassed(NotPassed4Public notPassed) throws PersistenceException;
    public void handlePassed(Passed4Public passed) throws PersistenceException;
    
}
