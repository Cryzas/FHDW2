
package view.visitor;
import view.*;

public interface EntryVisitor {
    
    public void handleCredit(CreditView credit) throws ModelException;
    public void handleDebit(DebitView debit) throws ModelException;
    
}
