
package model.visitor;
import persistence.*;

public interface ObsInterfaceReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAccountManagerCurrentAccounts(AccountManagerCurrentAccounts4Public accountManagerCurrentAccounts) throws PersistenceException, E;
    public R handleAccountWrpprAccount(AccountWrpprAccount4Public accountWrpprAccount) throws PersistenceException, E;
    public R handleServerAccounts(ServerAccounts4Public serverAccounts) throws PersistenceException, E;
    
}
