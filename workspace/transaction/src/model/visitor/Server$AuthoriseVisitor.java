
package model.visitor;

import persistence.*;

public abstract class Server$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleAccount(PersistentAccount account) throws PersistenceException;
    public abstract void handleDebit(PersistentDebit debit) throws PersistenceException;
    public abstract void handleTransferManager(PersistentTransferManager transferManager) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleAccountWrppr(PersistentAccountWrppr accountWrppr) throws PersistenceException;
    public abstract void handleCredit(PersistentCredit credit) throws PersistenceException;
    public abstract void handleTransaction(PersistentTransaction transaction) throws PersistenceException;
    public abstract void handleTransfer(PersistentTransfer transfer) throws PersistenceException;
    public abstract void handleAccountManager(PersistentAccountManager accountManager) throws PersistenceException;
    
}
