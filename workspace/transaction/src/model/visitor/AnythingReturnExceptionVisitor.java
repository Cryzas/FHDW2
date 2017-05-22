
package model.visitor;

import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends AccountHandleReturnExceptionVisitor<R, E> ,BookableReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> ,EntryReturnExceptionVisitor<R, E> {
    
    public R handleAccountManager(AccountManager4Public accountManager) throws PersistenceException, E;
    public R handleAddTransferCommand(AddTransferCommand4Public addTransferCommand) throws PersistenceException, E;
    public R handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException, E;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException, E;
    public R handleCreateTransactionCommand(CreateTransactionCommand4Public createTransactionCommand) throws PersistenceException, E;
    public R handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException, E;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public R handleRemoveTransferCommand(RemoveTransferCommand4Public removeTransferCommand) throws PersistenceException, E;
    public R handleServer(Server4Public server) throws PersistenceException, E;
    public R handleSubj(Subj4Public subj) throws PersistenceException, E;
    public R handleTransferManager(TransferManager4Public transferManager) throws PersistenceException, E;
    
}
