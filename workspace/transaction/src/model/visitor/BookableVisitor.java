
package model.visitor;

import persistence.*;

public interface BookableVisitor {
    
    public void handleTransaction(Transaction4Public transaction) throws PersistenceException;
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException;
    
}
