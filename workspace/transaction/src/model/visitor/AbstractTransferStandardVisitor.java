
package model.visitor;

import persistence.*;

public abstract class AbstractTransferStandardVisitor implements AbstractTransferVisitor {
    
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    protected abstract void standardHandling(AbstractTransfer4Public abstractTransfer) throws PersistenceException;
}
