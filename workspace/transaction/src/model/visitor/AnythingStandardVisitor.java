
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException{
        this.standardHandling(transferManager);
    }
    public void handleDebit(Debit4Public debit) throws PersistenceException{
        this.standardHandling(debit);
    }
    public void handleAccount(Account4Public account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleRemoveTransferCommand(RemoveTransferCommand4Public removeTransferCommand) throws PersistenceException{
        this.standardHandling(removeTransferCommand);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleSubj(Subj4Public subj) throws PersistenceException{
        this.standardHandling(subj);
    }
    public void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException{
        this.standardHandling(accountWrppr);
    }
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleCredit(Credit4Public credit) throws PersistenceException{
        this.standardHandling(credit);
    }
    public void handleCreateTransactionCommand(CreateTransactionCommand4Public createTransactionCommand) throws PersistenceException{
        this.standardHandling(createTransactionCommand);
    }
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException{
        this.standardHandling(bookCommand);
    }
    public void handleTransaction(Transaction4Public transaction) throws PersistenceException{
        this.standardHandling(transaction);
    }
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException{
        this.standardHandling(accountManager);
    }
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException{
        this.standardHandling(createTransferCommand);
    }
    public void handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException{
        this.standardHandling(createAccountCommand);
    }
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleAddTransferCommand(AddTransferCommand4Public addTransferCommand) throws PersistenceException{
        this.standardHandling(addTransferCommand);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
