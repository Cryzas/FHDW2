
package model.visitor;

import persistence.*;

public interface SubjInterfaceReturnVisitor<R> extends AbstractTransferReturnVisitor<R> ,AccountHandleReturnVisitor<R> ,EntryReturnVisitor<R> {
    
    public R handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    public R handleSubj(Subj4Public subj) throws PersistenceException;
    public R handleTransferManager(TransferManager4Public transferManager) throws PersistenceException;
    
}
