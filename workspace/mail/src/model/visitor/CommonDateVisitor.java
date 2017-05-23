
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException;
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public void handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException;
    public void handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException;
    public void handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
