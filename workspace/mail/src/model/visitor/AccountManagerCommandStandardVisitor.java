
package model.visitor;

import persistence.*;

public abstract class AccountManagerCommandStandardVisitor implements AccountManagerCommandVisitor {
    
    public void handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException{
        this.standardHandling(sendCommand);
    }
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
    }
    public void handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException{
        this.standardHandling(createDraftCommand);
    }
    public void handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException{
        this.standardHandling(addReceiverCommand);
    }
    public void handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException{
        this.standardHandling(createFolderCommand);
    }
    protected abstract void standardHandling(AccountManagerCommand accountManagerCommand) throws PersistenceException;
}
