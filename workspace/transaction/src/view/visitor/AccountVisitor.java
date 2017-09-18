
package view.visitor;
import view.*;

public interface AccountVisitor {
    
    public void handleNoAccount(NoAccountView noAccount) throws ModelException;
    public void handleAccount(AccountView account) throws ModelException;
    
}
