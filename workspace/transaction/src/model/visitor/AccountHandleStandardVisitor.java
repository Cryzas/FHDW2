
package model.visitor;

import persistence.*;

public abstract class AccountHandleStandardVisitor implements AccountHandleVisitor {
    
    public void handleAccount(Account4Public account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException{
        this.standardHandling(accountWrppr);
    }
    protected abstract void standardHandling(AccountHandle4Public accountHandle) throws PersistenceException;
}
