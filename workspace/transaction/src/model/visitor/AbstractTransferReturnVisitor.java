
package model.visitor;
import persistence.*;

public interface AbstractTransferReturnVisitor<R> {
    
    public R handleTransfer(Transfer4Public transfer) throws PersistenceException;
    
}
