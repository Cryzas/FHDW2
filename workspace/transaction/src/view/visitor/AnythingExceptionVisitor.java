
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> extends AbstractTransferExceptionVisitor<E>,AccountHandleExceptionVisitor<E>,EntryExceptionVisitor<E>{
    
    public void handleAccountManager(AccountManagerView accountManager) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleTransferManager(TransferManagerView transferManager) throws ModelException, E;
    
}
