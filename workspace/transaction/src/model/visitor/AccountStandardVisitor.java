
package model.visitor;

import persistence.*;

public abstract class AccountStandardVisitor implements AccountVisitor {
    
    public void handleAccount(Account4Public account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleNoAccount(NoAccount4Public noAccount) throws PersistenceException{
        this.standardHandling(noAccount);
    }
    protected abstract void standardHandling(Account4Public account) throws PersistenceException;
}
