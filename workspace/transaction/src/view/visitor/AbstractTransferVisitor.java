
package view.visitor;
import view.*;

public interface AbstractTransferVisitor {
    
    public void handleTransfer(TransferView transfer) throws ModelException;
    
}
