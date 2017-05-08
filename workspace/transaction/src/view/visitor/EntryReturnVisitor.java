
package view.visitor;

import view.*;

public interface EntryReturnVisitor<R> {
    
    public R handleCredit(CreditView credit) throws ModelException;
    public R handleDebit(DebitView debit) throws ModelException;
    
}
