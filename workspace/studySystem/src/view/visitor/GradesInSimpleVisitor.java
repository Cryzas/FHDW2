
package view.visitor;
import view.*;

public interface GradesInSimpleVisitor {
    
    public void handleNotPassed(NotPassedView notPassed) throws ModelException;
    public void handlePassed(PassedView passed) throws ModelException;
    
}
