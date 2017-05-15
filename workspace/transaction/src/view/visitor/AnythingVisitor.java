
package view.visitor;

import view.*;

public interface AnythingVisitor extends AbstractTransferVisitor,AccountHandleVisitor,EntryVisitor{
    
    public void handleAccountManager(AccountManagerView accountManager) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleTransferManager(TransferManagerView transferManager) throws ModelException;
    
}
