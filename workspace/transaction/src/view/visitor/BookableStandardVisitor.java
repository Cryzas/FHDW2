
package view.visitor;

import view.*;

public abstract class BookableStandardVisitor implements BookableVisitor {
    
    public void handleTransaction(TransactionView transaction) throws ModelException{
        this.standardHandling(transaction);
    }
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    protected abstract void standardHandling(BookableView bookable) throws ModelException;
}
