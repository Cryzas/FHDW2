
package view.visitor;

import view.*;

public abstract class AccountHandleStandardVisitor implements AccountHandleVisitor {
    
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleNoAccount(NoAccountView noAccount) throws ModelException{
        this.standardHandling(noAccount);
    }
    public void handleAccountWrppr(AccountWrpprView accountWrppr) throws ModelException{
        this.standardHandling(accountWrppr);
    }
    protected abstract void standardHandling(AccountHandleView accountHandle) throws ModelException;
}
