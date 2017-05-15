
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends AbstractTransferReturnVisitor<R> ,AccountHandleReturnVisitor<R> ,EntryReturnVisitor<R> {
    
    public R handleAccountManager(AccountManagerView accountManager) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleTransferManager(TransferManagerView transferManager) throws ModelException;
    
}
