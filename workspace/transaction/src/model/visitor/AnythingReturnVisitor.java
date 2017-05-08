
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends CommonDateReturnVisitor<R> ,EntryReturnVisitor<R> {
    
    public R handleAccount(Account4Public account) throws PersistenceException;
    public R handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public R handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public R handleManager(Manager4Public manager) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    public R handleTransfer(Transfer4Public transfer) throws PersistenceException;
    
}
