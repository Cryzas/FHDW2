
package model.visitor;
import persistence.*;

public interface ObsInterfaceReturnVisitor<R> {
    
    public R handleAccountManagerCurrentAccounts(AccountManagerCurrentAccounts4Public accountManagerCurrentAccounts) throws PersistenceException;
    public R handleAccountWrpprAccount(AccountWrpprAccount4Public accountWrpprAccount) throws PersistenceException;
    public R handleServerAccounts(ServerAccounts4Public serverAccounts) throws PersistenceException;
    
}
