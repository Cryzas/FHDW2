
package model.visitor;

import persistence.*;

public interface AccountHandleReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAccount(Account4Public account) throws PersistenceException, E;
    public R handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException, E;
    
}
