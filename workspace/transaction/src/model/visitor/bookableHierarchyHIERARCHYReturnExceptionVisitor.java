
package model.visitor;

import persistence.*;

public interface bookableHierarchyHIERARCHYReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleTransaction(Transaction4Public transaction) throws PersistenceException, E;
    public R handleTransfer(Transfer4Public transfer) throws PersistenceException, E;
    
}
