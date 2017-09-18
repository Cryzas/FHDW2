
package model.visitor;
import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends AbstractTransferReturnExceptionVisitor<R, E> ,AccountHandleReturnExceptionVisitor<R, E> ,CommonDateReturnExceptionVisitor<R, E> ,EntryReturnExceptionVisitor<R, E> ,TransferStateReturnExceptionVisitor<R, E> {
    
    public R handleAccountManager(AccountManager4Public accountManager) throws PersistenceException, E;
    public R handleAccountManagerCurrentAccounts(AccountManagerCurrentAccounts4Public accountManagerCurrentAccounts) throws PersistenceException, E;
    public R handleAccountWrpprAccount(AccountWrpprAccount4Public accountWrpprAccount) throws PersistenceException, E;
    public R handleBookCommand(BookCommand4Public bookCommand) throws PersistenceException, E;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public R handleCreateAccountCommand(CreateAccountCommand4Public createAccountCommand) throws PersistenceException, E;
    public R handleCreateTransferCommand(CreateTransferCommand4Public createTransferCommand) throws PersistenceException, E;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public R handleServer(Server4Public server) throws PersistenceException, E;
    public R handleServerAccounts(ServerAccounts4Public serverAccounts) throws PersistenceException, E;
    public R handleSubj(Subj4Public subj) throws PersistenceException, E;
    public R handleTransferManager(TransferManager4Public transferManager) throws PersistenceException, E;
    public R handleWrapperRecycle(WrapperRecycle4Public wrapperRecycle) throws PersistenceException, E;
    
}
