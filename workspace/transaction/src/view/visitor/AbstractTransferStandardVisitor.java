
package view.visitor;

import view.*;

public abstract class AbstractTransferStandardVisitor implements AbstractTransferVisitor {
    
    public void handleTransfer(TransferView transfer) throws ModelException{
        this.standardHandling(transfer);
    }
    protected abstract void standardHandling(AbstractTransferView abstractTransfer) throws ModelException;
}
