
package model.visitor;

import persistence.*;

public interface abstractAccExceptionVisitor<E extends model.UserException> {
    
    public void handleAccount(Account4Public account) throws PersistenceException, E;
    public void handleAccountWrapper(AccountWrapper4Public accountWrapper) throws PersistenceException, E;
    
}
