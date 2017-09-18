
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleDebit(Debit4Public debit) throws PersistenceException{
        this.standardHandling(debit);
    }
    public void handleAccount(Account4Public account) throws PersistenceException{
        this.standardHandling(account);
    }
    public void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException{
        this.standardHandling(transferManager);
    }
    public void handleWrapperRecycle(WrapperRecycle4Public wrapperRecycle) throws PersistenceException{
        this.standardHandling(wrapperRecycle);
    }
    public void handleServerAccounts(ServerAccounts4Public serverAccounts) throws PersistenceException{
        this.standardHandling(serverAccounts);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleNoAccount(NoAccount4Public noAccount) throws PersistenceException{
        this.standardHandling(noAccount);
    }
    public void handleNotBooked(NotBooked4Public notBooked) throws PersistenceException{
        this.standardHandling(notBooked);
    }
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleAccountWrpprAccount(AccountWrpprAccount4Public accountWrpprAccount) throws PersistenceException{
        this.standardHandling(accountWrpprAccount);
    }
    public void handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException{
        this.standardHandling(accountWrppr);
    }
    public void handleSubj(Subj4Public subj) throws PersistenceException{
        this.standardHandling(subj);
    }
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleCredit(Credit4Public credit) throws PersistenceException{
        this.standardHandling(credit);
    }
    public void handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException{
        this.standardHandling(bookCommand);
    }
    public void handleTransfer(Transfer4Public transfer) throws PersistenceException{
        this.standardHandling(transfer);
    }
    public void handleBooked(Booked4Public booked) throws PersistenceException{
        this.standardHandling(booked);
    }
    public void handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException{
        this.standardHandling(createTransferCommand);
    }
    public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException{
        this.standardHandling(accountManager);
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
    public void handleAccountManagerCurrentAccounts(AccountManagerCurrentAccounts4Public accountManagerCurrentAccounts) throws PersistenceException{
        this.standardHandling(accountManagerCurrentAccounts);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}
