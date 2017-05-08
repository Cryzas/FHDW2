
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends CommonDateVisitor,EntryVisitor{
    
    public void handleAccount(Account4Public account) throws PersistenceException;
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public void handleManager(Manager4Public manager) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException;
    
}
