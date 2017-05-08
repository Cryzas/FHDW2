
package model.visitor;

import persistence.*;

public interface EntryVisitor {
    
    public void handleCredit(Credit4Public credit) throws PersistenceException;
    public void handleDebit(Debit4Public debit) throws PersistenceException;
    
}
