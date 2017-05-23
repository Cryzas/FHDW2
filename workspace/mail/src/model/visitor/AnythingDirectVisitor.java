
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    
    public abstract void handleMail(Mail4Public mail) throws PersistenceException;
    
    public void handleDraft(Draft4Public draft) throws PersistenceException{
        this.handleMail(draft);
    }
    public void handleMailEntry(MailEntry4Public mailEntry) throws PersistenceException{
        this.handleMail(mailEntry);
    }
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
    public abstract void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    
    public abstract void handleFolder(Folder4Public folder) throws PersistenceException;
    
    public abstract void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
    public void handleSendCommand(SendCommand4Public sendCommand) throws PersistenceException{
        this.handleCommonDate(sendCommand);
    }
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException{
        this.handleCommonDate(createAccountCommand);
    }
    public void handleCreateDraftCommand(CreateDraftCommand4Public createDraftCommand) throws PersistenceException{
        this.handleCommonDate(createDraftCommand);
    }
    public void handleAddReceiverCommand(AddReceiverCommand4Public addReceiverCommand) throws PersistenceException{
        this.handleCommonDate(addReceiverCommand);
    }
    public void handleCreateFolderCommand(CreateFolderCommand4Public createFolderCommand) throws PersistenceException{
        this.handleCommonDate(createFolderCommand);
    }
    public abstract void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    
    public abstract void handleabstractAcc(abstractAcc4Public abstractAcc) throws PersistenceException;
    
    public void handleAccount(Account4Public account) throws PersistenceException{
        this.handleabstractAcc(account);
    }
    public void handleAccountWrapper(AccountWrapper4Public accountWrapper) throws PersistenceException{
        this.handleabstractAcc(accountWrapper);
    }
    
}
