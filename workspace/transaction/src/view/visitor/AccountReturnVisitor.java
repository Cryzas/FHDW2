
package view.visitor;
import view.*;

public interface AccountReturnVisitor<R> {
    
    public R handleNoAccount(NoAccountView noAccount) throws ModelException;
    public R handleAccount(AccountView account) throws ModelException;
    
}
