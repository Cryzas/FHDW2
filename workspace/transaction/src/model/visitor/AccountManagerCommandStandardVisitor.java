
package model.visitor;

import persistence.*;

public abstract class AccountManagerCommandStandardVisitor implements AccountManagerCommandVisitor {
    
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
    }
    protected abstract void standardHandling(AccountManagerCommand accountManagerCommand) throws PersistenceException;
}
