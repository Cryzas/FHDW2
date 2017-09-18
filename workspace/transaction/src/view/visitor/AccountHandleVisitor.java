
package view.visitor;
import view.*;

public interface AccountHandleVisitor extends AccountVisitor{
    
    public void handleAccount(AccountView account) throws ModelException;
    public void handleAccountWrppr(AccountWrpprView accountWrppr) throws ModelException;
    
}
