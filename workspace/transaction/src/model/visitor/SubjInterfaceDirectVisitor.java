
package model.visitor;

import persistence.*;

public abstract class SubjInterfaceDirectVisitor implements SubjInterfaceVisitor {
    
    public abstract void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException;
    
    public abstract void handleEntry(Entry4Public entry) throws PersistenceException;
    
    public void handleDebit(Debit4Public debit) throws PersistenceException{
        this.handleEntry(debit);
    }
    public void handleCredit(Credit4Public credit) throws PersistenceException{
        this.handleEntry(credit);
    }
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
    public abstract void handleAccountHandle(AccountHandle4Public accountHandle) throws PersistenceException;
    
    public void handleAccount(Account4Public account) throws PersistenceException{
        this.handleAccountHandle(account);
    }
    public void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException{
        this.handleAccountHandle(accountWrppr);
    }
    public abstract void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    
    public abstract void handleSubj(Subj4Public subj) throws PersistenceException;
    
    public abstract void handleBookable(Bookable4Public bookable) throws PersistenceException;
    
    public void handleTransaction(Transaction4Public transaction) throws PersistenceException{
        this.handleBookable(transaction);
    }
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException{
        this.handleBookable(transfer);
    }
    
}
