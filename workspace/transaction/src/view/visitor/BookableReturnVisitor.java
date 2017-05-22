
package view.visitor;

import view.*;

public interface BookableReturnVisitor<R> {
    
    public R handleTransaction(TransactionView transaction) throws ModelException;
    public R handleTransfer(TransferView transfer) throws ModelException;
    
}
