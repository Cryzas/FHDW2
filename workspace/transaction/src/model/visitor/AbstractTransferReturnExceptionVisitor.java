
package model.visitor;

import persistence.*;

public interface AbstractTransferReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleTransfer(Transfer4Public transfer) throws PersistenceException, E;
    
}
