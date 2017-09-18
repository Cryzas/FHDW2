
package model.visitor;
import persistence.*;

public interface AnythingReturnVisitor<R> extends AbstractTransferReturnVisitor<R> ,AccountHandleReturnVisitor<R> ,CommonDateReturnVisitor<R> ,EntryReturnVisitor<R> ,TransferStateReturnVisitor<R> {
    
    public R handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    public R handleAccountManagerCurrentAccounts(AccountManagerCurrentAccounts4Public accountManagerCurrentAccounts) throws PersistenceException;
    public R handleAccountWrpprAccount(AccountWrpprAccount4Public accountWrpprAccount) throws PersistenceException;
    public R handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException;
    public R handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    public R handleServerAccounts(ServerAccounts4Public serverAccounts) throws PersistenceException;
    public R handleSubj(Subj4Public subj) throws PersistenceException;
    public R handleTransferManager(TransferManager4Public transferManager) throws PersistenceException;
    public R handleWrapperRecycle(WrapperRecycle4Public wrapperRecycle) throws PersistenceException;
    
}
