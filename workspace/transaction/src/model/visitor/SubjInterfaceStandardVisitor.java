
package model.visitor;

import persistence.*;

public abstract class SubjInterfaceStandardVisitor implements SubjInterfaceVisitor {
    
    public void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException{
        this.standardHandling(transferManager);
    }
    public void handleDebit(Debit4Public debit) throws PersistenceException{
        this.standardHandling(debit);
    }
    public void handleAccount(Account4Public account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleCredit(Credit4Public credit) throws PersistenceException{
        this.standardHandling(credit);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException{
        this.standardHandling(accountManager);
    }
    public void handleSubj(Subj4Public subj) throws PersistenceException{
        this.standardHandling(subj);
    }
    public void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException{
        this.standardHandling(accountWrppr);
    }
    protected abstract void standardHandling(SubjInterface subjInterface) throws PersistenceException;
}
