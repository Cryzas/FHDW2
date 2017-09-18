
package model.visitor;
import persistence.*;

public interface AccountManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException, E;
    
}
