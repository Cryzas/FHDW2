
package view.visitor;

import view.*;

public interface AccountHandleVisitor {
    
    public void handleAccount(AccountView account) throws ModelException;
    public void handleAccountWrppr(AccountWrpprView accountWrppr) throws ModelException;
    
}
