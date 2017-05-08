
package model.visitor;

import persistence.*;

public interface EntryReturnVisitor<R> {
    
    public R handleCredit(Credit4Public credit) throws PersistenceException;
    public R handleDebit(Debit4Public debit) throws PersistenceException;
    
}
