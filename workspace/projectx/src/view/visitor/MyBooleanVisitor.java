
package view.visitor;
import view.*;

public interface MyBooleanVisitor {
    
    public void handleBFalse(BFalseView bFalse) throws ModelException;
    public void handleBTrue(BTrueView bTrue) throws ModelException;
    
}
