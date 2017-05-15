
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends AbstractTransferReturnExceptionVisitor<R, E> ,AccountHandleReturnExceptionVisitor<R, E> ,EntryReturnExceptionVisitor<R, E> {
    
    public R handleAccountManager(AccountManagerView accountManager) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleTransferManager(TransferManagerView transferManager) throws ModelException, E;
    
}
