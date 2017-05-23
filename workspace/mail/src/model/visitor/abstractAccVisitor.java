
package model.visitor;

import persistence.*;

public interface abstractAccVisitor {
    
    public void handleAccount(Account4Public account) throws PersistenceException;
    public void handleAccountWrapper(AccountWrapper4Public accountWrapper) throws PersistenceException;
    
}
