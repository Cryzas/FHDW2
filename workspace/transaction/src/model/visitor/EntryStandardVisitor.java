
package model.visitor;

import persistence.*;

public abstract class EntryStandardVisitor implements EntryVisitor {
    
    public void handleDebit(Debit4Public debit) throws PersistenceException{
        this.standardHandling(debit);
    }
    public void handleCredit(Credit4Public credit) throws PersistenceException{
        this.standardHandling(credit);
    }
    protected abstract void standardHandling(Entry4Public entry) throws PersistenceException;
}
