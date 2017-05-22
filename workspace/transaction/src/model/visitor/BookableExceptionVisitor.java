
package model.visitor;

import persistence.*;

public interface BookableExceptionVisitor<E extends model.UserException> {
    
    public void handleTransaction(Transaction4Public transaction) throws PersistenceException, E;
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException, E;
    
}
