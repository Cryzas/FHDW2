
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleDebit(Debit4Public debit) throws PersistenceException;
    public abstract void handleAccount(Account4Public account) throws PersistenceException;
    public abstract void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException;
    public abstract void handleWrapperRecycle(WrapperRecycle4Public wrapperRecycle) throws PersistenceException;
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleNoAccount(NoAccount4Public noAccount) throws PersistenceException;
    public abstract void handleNotBooked(NotBooked4Public notBooked) throws PersistenceException;
    public abstract void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException;
    public abstract void handleCredit(Credit4Public credit) throws PersistenceException;
    public abstract void handleTransfer(Transfer4Public transfer) throws PersistenceException;
    public abstract void handleBooked(Booked4Public booked) throws PersistenceException;
    public abstract void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    
}
