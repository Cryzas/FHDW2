
package model.visitor;

import persistence.*;

public abstract class AccountHandleDirectVisitor implements AccountHandleVisitor {
    
    public abstract void handleAccount(Account4Public account) throws PersistenceException;
    
    public void handleNoAccount(NoAccount4Public noAccount) throws PersistenceException{
        this.handleAccount(noAccount);
    }
    public abstract void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException;
    
    
}
