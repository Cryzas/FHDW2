
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleTransferManager(TransferManagerView transferManager) throws ModelException{
        this.standardHandling(transferManager);
    }
    public void handleDebit(DebitView debit) throws ModelException{
        this.standardHandling(debit);
    }
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleAccountWrppr(AccountWrpprView accountWrppr) throws ModelException{
        this.standardHandling(accountWrppr);
    }
    public void handleCredit(CreditView credit) throws ModelException{
        this.standardHandling(credit);
    }
    public void handleTransaction(TransactionView transaction) throws ModelException{
        this.standardHandling(transaction);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    public void handleAccountManager(AccountManagerView accountManager) throws ModelException{
        this.standardHandling(accountManager);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
