
package model.visitor;
import persistence.*;

public interface EntryExceptionVisitor<E extends model.UserException> {
    
    public void handleCredit(Credit4Public credit) throws PersistenceException, E;
    public void handleDebit(Debit4Public debit) throws PersistenceException, E;
    
}
