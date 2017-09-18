
package model.visitor;

import persistence.*;

public abstract class ObsInterfaceStandardVisitor implements ObsInterfaceVisitor {
    
    public void handleServerAccounts(ServerAccounts4Public serverAccounts) throws PersistenceException{
        this.standardHandling(serverAccounts);
    }
    public void handleAccountWrpprAccount(AccountWrpprAccount4Public accountWrpprAccount) throws PersistenceException{
        this.standardHandling(accountWrpprAccount);
    }
    public void handleAccountManagerCurrentAccounts(AccountManagerCurrentAccounts4Public accountManagerCurrentAccounts) throws PersistenceException{
        this.standardHandling(accountManagerCurrentAccounts);
    }
    protected abstract void standardHandling(ObsInterface obsInterface) throws PersistenceException;
}
