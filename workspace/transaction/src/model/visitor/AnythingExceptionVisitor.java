
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends AbstractTransferExceptionVisitor<E>,AccountHandleExceptionVisitor<E>,CommonDateExceptionVisitor<E>,EntryExceptionVisitor<E>{
    
    public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException, E;
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException, E;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException, E;
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException, E;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    public void handleSubj(Subj4Public subj) throws PersistenceException, E;
    public void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException, E;
    
}
