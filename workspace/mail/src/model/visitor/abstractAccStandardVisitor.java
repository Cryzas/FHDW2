
package model.visitor;

import persistence.*;

public abstract class abstractAccStandardVisitor implements abstractAccVisitor {
    
    public void handleAccount(Account4Public account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleAccountWrapper(AccountWrapper4Public accountWrapper) throws PersistenceException{
        this.standardHandling(accountWrapper);
    }
    protected abstract void standardHandling(abstractAcc4Public abstractAcc) throws PersistenceException;
}
