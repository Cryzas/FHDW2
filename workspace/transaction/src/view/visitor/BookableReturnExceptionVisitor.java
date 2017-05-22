
package view.visitor;

import view.*;

public interface BookableReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleTransaction(TransactionView transaction) throws ModelException, E;
    public R handleTransfer(TransferView transfer) throws ModelException, E;
    
}
