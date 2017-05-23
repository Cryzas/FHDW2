
package model.visitor;

import persistence.*;

public interface abstractAccReturnVisitor<R> {
    
    public R handleAccount(Account4Public account) throws PersistenceException;
    public R handleAccountWrapper(AccountWrapper4Public accountWrapper) throws PersistenceException;
    
}
