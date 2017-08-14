
package model.visitor;

import persistence.*;

public interface AccountManagerCommandReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException, E;
    public R handleAnswerAllCommand(AnswerAllCommand4Public answerAllCommand) throws PersistenceException, E;
    public R handleAnswerCommand(AnswerCommand4Public answerCommand) throws PersistenceException, E;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException, E;
    public R handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException, E;
    public R handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException, E;
    public R handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException, E;
    
}
