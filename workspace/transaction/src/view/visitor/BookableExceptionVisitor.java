
package view.visitor;

import view.*;

public interface BookableExceptionVisitor<E extends view.UserException> {
    
    public void handleTransaction(TransactionView transaction) throws ModelException, E;
    public void handleTransfer(TransferView transfer) throws ModelException, E;
    
}
