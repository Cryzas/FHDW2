
package model.visitor;

import persistence.*;

public interface abstractAccReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAccount(Account4Public account) throws PersistenceException, E;
    public R handleAccountWrapper(AccountWrapper4Public accountWrapper) throws PersistenceException, E;
    
}
