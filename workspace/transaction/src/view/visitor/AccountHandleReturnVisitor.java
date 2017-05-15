
package view.visitor;

import view.*;

public interface AccountHandleReturnVisitor<R> {
    
    public R handleAccount(AccountView account) throws ModelException;
    public R handleAccountWrppr(AccountWrpprView accountWrppr) throws ModelException;
    
}
