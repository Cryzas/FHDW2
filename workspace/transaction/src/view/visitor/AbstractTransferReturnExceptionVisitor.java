
package view.visitor;

import view.*;

public interface AbstractTransferReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleTransfer(TransferView transfer) throws ModelException, E;
    
}
