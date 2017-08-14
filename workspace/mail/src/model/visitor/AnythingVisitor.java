
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends CommonDateVisitor,MailVisitor,abstractAccVisitor{
    
    public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    public void handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException;
    public void handleAnswerAllCommand(AnswerAllCommand4Public answerAllCommand) throws PersistenceException;
    public void handleAnswerCommand(AnswerCommand4Public answerCommand) throws PersistenceException;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public void handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException;
    public void handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public void handleFolder(Folder4Public folder) throws PersistenceException;
    public void handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    
}
