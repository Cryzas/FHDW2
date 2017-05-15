
package model.visitor;

import persistence.*;

public interface AbstractTransferExceptionVisitor<E extends model.UserException> {
    
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException, E;
    
}
