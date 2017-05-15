
package model.visitor;

import persistence.*;

public interface SubjInterfaceReturnExceptionVisitor<R, E extends model.UserException> extends AbstractTransferReturnExceptionVisitor<R, E> ,AccountHandleReturnExceptionVisitor<R, E> ,EntryReturnExceptionVisitor<R, E> {
    
    public R handleAccountManager(AccountManager4Public accountManager) throws PersistenceException, E;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public R handleServer(Server4Public server) throws PersistenceException, E;
    public R handleSubj(Subj4Public subj) throws PersistenceException, E;
    public R handleTransferManager(TransferManager4Public transferManager) throws PersistenceException, E;
    
}
