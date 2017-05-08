
package view.visitor;

import view.*;

public interface EntryReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleCredit(CreditView credit) throws ModelException, E;
    public R handleDebit(DebitView debit) throws ModelException, E;
    
}
