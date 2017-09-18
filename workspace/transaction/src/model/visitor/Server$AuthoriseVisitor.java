
package model.visitor;

import persistence.*;

public abstract class Server$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleAccount(PersistentAccount account) throws PersistenceException;
    public abstract void handleDebit(PersistentDebit debit) throws PersistenceException;
    public abstract void handleTransferManager(PersistentTransferManager transferManager) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleNoAccount(PersistentNoAccount noAccount) throws PersistenceException;
    public abstract void handleNotBooked(PersistentNotBooked notBooked) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleAccountWrppr(PersistentAccountWrppr accountWrppr) throws PersistenceException;
    public abstract void handleCredit(PersistentCredit credit) throws PersistenceException;
    public abstract void handleBooked(PersistentBooked booked) throws PersistenceException;
    public abstract void handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    public abstract void handleAccountManager(PersistentAccountManager accountManager) throws PersistenceException;
    
}
