
package view.visitor;
import view.*;

public interface AbstractTransferExceptionVisitor<E extends view.UserException> {
    
    public void handleTransfer(TransferView transfer) throws ModelException, E;
    
}
