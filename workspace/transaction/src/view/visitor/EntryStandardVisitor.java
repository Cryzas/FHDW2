
package view.visitor;

import view.*;

public abstract class EntryStandardVisitor implements EntryVisitor {
    
    public void handleDebit(DebitView debit) throws ModelException{
        this.standardHandling(debit);
    }
    public void handleCredit(CreditView credit) throws ModelException{
        this.standardHandling(credit);
    }
    protected abstract void standardHandling(EntryView entry) throws ModelException;
}
