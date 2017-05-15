
package view.visitor;

import view.*;

public interface AccountHandleExceptionVisitor<E extends view.UserException> {
    
    public void handleAccount(AccountView account) throws ModelException, E;
    public void handleAccountWrppr(AccountWrpprView accountWrppr) throws ModelException, E;
    
}
