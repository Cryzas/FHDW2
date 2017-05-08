
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleDebit(DebitView debit) throws ModelException{
        this.standardHandling(debit);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleManager(ManagerView manager) throws ModelException{
        this.standardHandling(manager);
    }
    public void handleCredit(CreditView credit) throws ModelException{
        this.standardHandling(credit);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
