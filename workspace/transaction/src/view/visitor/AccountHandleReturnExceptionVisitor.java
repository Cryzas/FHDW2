
package view.visitor;
import view.*;

public interface AccountHandleReturnExceptionVisitor<R, E extends view.UserException> extends AccountReturnExceptionVisitor<R, E> {
    
    public R handleAccount(AccountView account) throws ModelException, E;
    public R handleAccountWrppr(AccountWrpprView accountWrppr) throws ModelException, E;
    
}
