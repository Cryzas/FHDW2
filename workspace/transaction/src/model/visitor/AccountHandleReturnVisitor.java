
package model.visitor;
import persistence.*;

public interface AccountHandleReturnVisitor<R> extends AccountReturnVisitor<R> {
    
    public R handleAccount(Account4Public account) throws PersistenceException;
    public R handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException;
    
}
