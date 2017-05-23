
package view.visitor;

import view.*;

public abstract class abstractAccStandardVisitor implements abstractAccVisitor {
    
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleAccountWrapper(AccountWrapperView accountWrapper) throws ModelException{
        this.standardHandling(accountWrapper);
    }
    protected abstract void standardHandling(abstractAccView abstractAcc) throws ModelException;
}
