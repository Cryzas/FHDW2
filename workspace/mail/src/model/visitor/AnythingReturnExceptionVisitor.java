
package model.visitor;

import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends CommonDateReturnExceptionVisitor<R, E> ,MailReturnExceptionVisitor<R, E> ,abstractAccReturnExceptionVisitor<R, E> {
    
    public R handleAccountManager(AccountManager4Public accountManager) throws PersistenceException, E;
    public R handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException, E;
    public R handleAnswerAllCommand(AnswerAllCommand4Public answerAllCommand) throws PersistenceException, E;
    public R handleAnswerCommand(AnswerCommand4Public answerCommand) throws PersistenceException, E;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException, E;
    public R handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException, E;
    public R handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException, E;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public R handleFolder(Folder4Public folder) throws PersistenceException, E;
    public R handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException, E;
    public R handleServer(Server4Public server) throws PersistenceException, E;
    
}
