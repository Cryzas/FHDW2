
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleTransferManager(TransferManagerView transferManager) throws ModelException;
    
    public abstract void handleWrapperRecycle(WrapperRecycleView wrapperRecycle) throws ModelException;
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleAbstractTransfer(AbstractTransferView abstractTransfer) throws ModelException;
    
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.handleAbstractTransfer(transfer);
    }
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleTransferState(TransferStateView transferState) throws ModelException;
    
    public void handleNotBooked(NotBookedView notBooked) throws ModelException{
        this.handleTransferState(notBooked);
    }
    public void handleBooked(BookedView booked) throws ModelException{
        this.handleTransferState(booked);
    }
    public abstract void handleEntry(EntryView entry) throws ModelException;
    
    public void handleDebit(DebitView debit) throws ModelException{
        this.handleEntry(debit);
    }
    public void handleCredit(CreditView credit) throws ModelException{
        this.handleEntry(credit);
    }
    public abstract void handleAccountHandle(AccountHandleView accountHandle) throws ModelException;
    
    public void handleAccount(AccountView account) throws ModelException{
        this.handleAccountHandle(account);
    }
    public void handleNoAccount(NoAccountView noAccount) throws ModelException{
        this.handleAccountHandle(noAccount);
    }
    public void handleAccountWrppr(AccountWrpprView accountWrppr) throws ModelException{
        this.handleAccountHandle(accountWrppr);
    }
    public abstract void handleAccountManager(AccountManagerView accountManager) throws ModelException;
    
    
}
