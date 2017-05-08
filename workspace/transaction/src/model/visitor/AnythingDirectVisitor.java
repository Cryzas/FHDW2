
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleAccount(Account4Public account) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    
    public abstract void handleEntry(Entry4Public entry) throws PersistenceException;
    
    public void handleDebit(Debit4Public debit) throws PersistenceException{
        this.handleEntry(debit);
    }
    public void handleCredit(Credit4Public credit) throws PersistenceException{
        this.handleEntry(credit);
    }
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    
    public abstract void handleTransfer(Transfer4Public transfer) throws PersistenceException;
    
    public abstract void handleManager(Manager4Public manager) throws PersistenceException;
    
    public abstract void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException{
        this.handleCommonDate(bookCommand);
    }
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException{
        this.handleCommonDate(createTransferCommand);
    }
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException{
        this.handleCommonDate(createAccountCommand);
    }
    public abstract void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    
    
}
