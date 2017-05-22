
package model.visitor;

import persistence.*;

public abstract class bookableHierarchyHIERARCHYStandardVisitor implements bookableHierarchyHIERARCHYVisitor {
    
    public void handleTransaction(Transaction4Public transaction) throws PersistenceException{
        this.standardHandling(transaction);
    }
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    protected abstract void standardHandling(bookableHierarchyHIERARCHY bookableHierarchyHIERARCHY) throws PersistenceException;
}
