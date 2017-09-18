
package view.visitor;
import view.*;

public interface AccountReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleNoAccount(NoAccountView noAccount) throws ModelException, E;
    public R handleAccount(AccountView account) throws ModelException, E;
    
}
