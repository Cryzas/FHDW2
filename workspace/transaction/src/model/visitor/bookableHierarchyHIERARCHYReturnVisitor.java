
package model.visitor;

import persistence.*;

public interface bookableHierarchyHIERARCHYReturnVisitor<R> {
    
    public R handleTransaction(Transaction4Public transaction) throws PersistenceException;
    public R handleTransfer(Transfer4Public transfer) throws PersistenceException;
    
}
