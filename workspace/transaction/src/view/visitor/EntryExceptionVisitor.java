
package view.visitor;
import view.*;

public interface EntryExceptionVisitor<E extends view.UserException> {
    
    public void handleCredit(CreditView credit) throws ModelException, E;
    public void handleDebit(DebitView debit) throws ModelException, E;
    
}
