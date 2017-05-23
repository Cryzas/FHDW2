
package model.visitor;

import persistence.*;

public interface CommonDateExceptionVisitor<E extends model.UserException> {
    
    public void handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException, E;
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException, E;
    public void handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException, E;
    public void handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException, E;
    public void handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    
}
