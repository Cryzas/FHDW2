
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends CommonDateReturnVisitor<R> ,MailReturnVisitor<R> ,abstractAccReturnVisitor<R> {
    
    public R handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    public R handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public R handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException;
    public R handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public R handleFolder(Folder4Public folder) throws PersistenceException;
    public R handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    
}
