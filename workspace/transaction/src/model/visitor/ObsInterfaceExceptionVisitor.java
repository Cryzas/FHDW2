
package model.visitor;
import persistence.*;

public interface ObsInterfaceExceptionVisitor<E extends model.UserException> {
    
    public void handleAccountManagerCurrentAccounts(AccountManagerCurrentAccounts4Public accountManagerCurrentAccounts) throws PersistenceException, E;
    public void handleAccountWrpprAccount(AccountWrpprAccount4Public accountWrpprAccount) throws PersistenceException, E;
    public void handleServerAccounts(ServerAccounts4Public serverAccounts) throws PersistenceException, E;
    
}
