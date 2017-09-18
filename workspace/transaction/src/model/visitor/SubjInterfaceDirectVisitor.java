
package model.visitor;

import persistence.*;

public abstract class SubjInterfaceDirectVisitor implements SubjInterfaceVisitor {
    
    public abstract void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException;
    
    public abstract void handleWrapperRecycle(WrapperRecycle4Public wrapperRecycle) throws PersistenceException;
    
    public abstract void handleEntry(Entry4Public entry) throws PersistenceException;
    
    public void handleDebit(Debit4Public debit) throws PersistenceException{
        this.handleEntry(debit);
    }
    public void handleCredit(Credit4Public credit) throws PersistenceException{
        this.handleEntry(credit);
    }
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleAbstractTransfer(AbstractTransfer4Public abstractTransfer) throws PersistenceException;
    
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException{
        this.handleAbstractTransfer(transfer);
    }
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
    public abstract void handleAccountHandle(AccountHandle4Public accountHandle) throws PersistenceException;
    
    public void handleAccount(Account4Public account) throws PersistenceException{
        this.handleAccountHandle(account);
    }
    public void handleNoAccount(NoAccount4Public noAccount) throws PersistenceException{
        this.handleAccountHandle(noAccount);
    }
    public void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException{
        this.handleAccountHandle(accountWrppr);
    }
    public abstract void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    
    public abstract void handleTransferState(TransferState4Public transferState) throws PersistenceException;
    
    public void handleNotBooked(NotBooked4Public notBooked) throws PersistenceException{
        this.handleTransferState(notBooked);
    }
    public void handleBooked(Booked4Public booked) throws PersistenceException{
        this.handleTransferState(booked);
    }
    public abstract void handleSubj(Subj4Public subj) throws PersistenceException;
    
    
}
