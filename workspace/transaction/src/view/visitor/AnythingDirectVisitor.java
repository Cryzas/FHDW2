
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleAccount(AccountView account) throws ModelException;
    
    public abstract void handleEntry(EntryView entry) throws ModelException;
    
    public void handleDebit(DebitView debit) throws ModelException{
        this.handleEntry(debit);
    }
    public void handleCredit(CreditView credit) throws ModelException{
        this.handleEntry(credit);
    }
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleTransfer(TransferView transfer) throws ModelException;
    
    public abstract void handleManager(ManagerView manager) throws ModelException;
    
    
}
