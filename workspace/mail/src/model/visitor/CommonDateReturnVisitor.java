
package model.visitor;

import persistence.*;

public interface CommonDateReturnVisitor<R> {
    
    public R handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public R handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException;
    public R handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException;
    public R handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
}
