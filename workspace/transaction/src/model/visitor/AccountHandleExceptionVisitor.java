
package model.visitor;
import persistence.*;

public interface AccountHandleExceptionVisitor<E extends model.UserException> extends AccountExceptionVisitor<E>{
    
    public void handleAccount(Account4Public account) throws PersistenceException, E;
    public void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException, E;
    
}
