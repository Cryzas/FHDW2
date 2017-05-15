
package view.visitor;

import view.*;

public interface AbstractTransferReturnVisitor<R> {
    
    public R handleTransfer(TransferView transfer) throws ModelException;
    
}
