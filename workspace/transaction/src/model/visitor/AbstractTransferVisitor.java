
package model.visitor;
import persistence.*;

public interface AbstractTransferVisitor {
    
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException;
    
}
