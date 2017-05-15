
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends AbstractTransferVisitor,AccountHandleVisitor,CommonDateVisitor,EntryVisitor{
    
    public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    public void handleSubj(Subj4Public subj) throws PersistenceException;
    public void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException;
    
}
