
package view.visitor;
import view.*;

public interface MyBooleanExceptionVisitor<E extends view.UserException> {
    
    public void handleBFalse(BFalseView bFalse) throws ModelException, E;
    public void handleBTrue(BTrueView bTrue) throws ModelException, E;
    
}
