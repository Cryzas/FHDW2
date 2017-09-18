
package view.visitor;

import view.*;

public abstract class AccountHandleDirectVisitor implements AccountHandleVisitor {
    
    public abstract void handleAccount(AccountView account) throws ModelException;
    
    public void handleNoAccount(NoAccountView noAccount) throws ModelException{
        this.handleAccount(noAccount);
    }
    public abstract void handleAccountWrppr(AccountWrpprView accountWrppr) throws ModelException;
    
    
}
