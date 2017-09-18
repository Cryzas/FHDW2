
package model.visitor;
import persistence.*;

public interface AccountHandleVisitor extends AccountVisitor{
    
    public void handleAccount(Account4Public account) throws PersistenceException;
    public void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException;
    
}
