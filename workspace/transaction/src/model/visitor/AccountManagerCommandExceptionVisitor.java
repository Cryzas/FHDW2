
package model.visitor;

import persistence.*;

public interface AccountManagerCommandExceptionVisitor<E extends model.UserException> {
    
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException, E;
    
}
