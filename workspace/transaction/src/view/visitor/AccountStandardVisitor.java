
package view.visitor;

import view.*;

public abstract class AccountStandardVisitor implements AccountVisitor {
    
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleNoAccount(NoAccountView noAccount) throws ModelException{
        this.standardHandling(noAccount);
    }
    protected abstract void standardHandling(AccountView account) throws ModelException;
}
