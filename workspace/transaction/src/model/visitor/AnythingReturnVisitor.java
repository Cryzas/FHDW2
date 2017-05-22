
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends AccountHandleReturnVisitor<R> ,BookableReturnVisitor<R> ,CommonDateReturnVisitor<R> ,EntryReturnVisitor<R> {
    
    public R handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    public R handleAddTransferCommand(AddTransferCommand4Public addTransferCommand) throws PersistenceException;
    public R handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public R handleCreateTransactionCommand(CreateTransactionCommand4Public createTransactionCommand) throws PersistenceException;
    public R handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public R handleRemoveTransferCommand(RemoveTransferCommand4Public removeTransferCommand) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    public R handleSubj(Subj4Public subj) throws PersistenceException;
    public R handleTransferManager(TransferManager4Public transferManager) throws PersistenceException;
    
}
