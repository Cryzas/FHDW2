
package view.visitor;
import view.*;

public interface MyBooleanReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleBFalse(BFalseView bFalse) throws ModelException, E;
    public R handleBTrue(BTrueView bTrue) throws ModelException, E;
    
}
