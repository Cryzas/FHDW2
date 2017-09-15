
package view.visitor;
import view.*;

public interface MyBooleanReturnVisitor<R> {
    
    public R handleBFalse(BFalseView bFalse) throws ModelException;
    public R handleBTrue(BTrueView bTrue) throws ModelException;
    
}
