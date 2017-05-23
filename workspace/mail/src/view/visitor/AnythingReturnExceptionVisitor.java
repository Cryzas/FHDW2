
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends MailReturnExceptionVisitor<R, E> ,abstractAccReturnExceptionVisitor<R, E> {
    
    public R handleAccountManager(AccountManagerView accountManager) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleFolder(FolderView folder) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    
}
