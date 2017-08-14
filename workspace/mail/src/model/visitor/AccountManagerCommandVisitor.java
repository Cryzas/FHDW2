
package model.visitor;

import persistence.*;

public interface AccountManagerCommandVisitor {
    
    public void handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException;
    public void handleAnswerAllCommand(AnswerAllCommand4Public answerAllCommand) throws PersistenceException;
    public void handleAnswerCommand(AnswerCommand4Public answerCommand) throws PersistenceException;
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public void handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException;
    public void handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException;
    public void handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException;
    
}
