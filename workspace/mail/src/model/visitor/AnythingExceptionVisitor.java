
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends CommonDateExceptionVisitor<E>,MailExceptionVisitor<E>,abstractAccExceptionVisitor<E>{
    
    public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException, E;
    public void handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException, E;
    public void handleAnswerAllCommand(AnswerAllCommand4Public answerAllCommand) throws PersistenceException, E;
    public void handleAnswerCommand(AnswerCommand4Public answerCommand) throws PersistenceException, E;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException, E;
    public void handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException, E;
    public void handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException, E;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleFolder(Folder4Public folder) throws PersistenceException, E;
    public void handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    
}
