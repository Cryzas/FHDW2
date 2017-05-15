
package model.visitor;

import persistence.*;

public interface AccountManagerCommandReturnVisitor<R> {
    
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    
}
