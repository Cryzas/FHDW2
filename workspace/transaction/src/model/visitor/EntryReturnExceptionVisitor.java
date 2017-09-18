
package model.visitor;
import persistence.*;

public interface EntryReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCredit(Credit4Public credit) throws PersistenceException, E;
    public R handleDebit(Debit4Public debit) throws PersistenceException, E;
    
}
