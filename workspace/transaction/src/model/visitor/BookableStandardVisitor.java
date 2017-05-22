
package model.visitor;

import persistence.*;

public abstract class BookableStandardVisitor implements BookableVisitor {
    
    public void handleTransaction(Transaction4Public transaction) throws PersistenceException{
        this.standardHandling(transaction);
    }
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    protected abstract void standardHandling(Bookable4Public bookable) throws PersistenceException;
}
