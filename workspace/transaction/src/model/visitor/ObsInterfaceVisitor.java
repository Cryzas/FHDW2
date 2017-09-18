
package model.visitor;
import persistence.*;

public interface ObsInterfaceVisitor {
    
    public void handleAccountManagerCurrentAccounts(AccountManagerCurrentAccounts4Public accountManagerCurrentAccounts) throws PersistenceException;
    public void handleAccountWrpprAccount(AccountWrpprAccount4Public accountWrpprAccount) throws PersistenceException;
    public void handleServerAccounts(ServerAccounts4Public serverAccounts) throws PersistenceException;
    
}
