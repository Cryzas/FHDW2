
package view.visitor;
import view.*;

public interface AccountExceptionVisitor<E extends view.UserException> {
    
    public void handleNoAccount(NoAccountView noAccount) throws ModelException, E;
    public void handleAccount(AccountView account) throws ModelException, E;
    
}
