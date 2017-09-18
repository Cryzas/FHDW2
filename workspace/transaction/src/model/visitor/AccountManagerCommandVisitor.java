
package model.visitor;
import persistence.*;

public interface AccountManagerCommandVisitor {
    
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    
}
