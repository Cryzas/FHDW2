
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleAccount(Account4Public account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleFolder(Folder4Public folder) throws PersistenceException{
        this.standardHandling(folder);
    }
    public void handleAccountWrapper(AccountWrapper4Public accountWrapper) throws PersistenceException{
        this.standardHandling(accountWrapper);
    }
    public void handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException{
        this.standardHandling(addReceiverCommand);
    }
    public void handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException{
        this.standardHandling(createFolderCommand);
    }
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleDraft(Draft4Public draft) throws PersistenceException{
        this.standardHandling(draft);
    }
    public void handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException{
        this.standardHandling(sendCommand);
    }
    public void handleMailEntry(MailEntry4Public mailEntry) throws PersistenceException{
        this.standardHandling(mailEntry);
    }
    public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException{
        this.standardHandling(accountManager);
    }
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
    }
    public void handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException{
        this.standardHandling(createDraftCommand);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
