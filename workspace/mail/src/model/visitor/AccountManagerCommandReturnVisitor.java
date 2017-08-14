
package model.visitor;

import persistence.*;

public interface AccountManagerCommandReturnVisitor<R> {
    
    public R handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException;
    public R handleAnswerAllCommand(AnswerAllCommand4Public answerAllCommand) throws PersistenceException;
    public R handleAnswerCommand(AnswerCommand4Public answerCommand) throws PersistenceException;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public R handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException;
    public R handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException;
    public R handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException;
    
}
