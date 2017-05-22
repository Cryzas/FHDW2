
package view.visitor;

import view.*;

public interface BookableVisitor {
    
    public void handleTransaction(TransactionView transaction) throws ModelException;
    public void handleTransfer(TransferView transfer) throws ModelException;
    
}
