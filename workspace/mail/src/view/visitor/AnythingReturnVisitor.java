
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends MailReturnVisitor<R> ,abstractAccReturnVisitor<R> {
    
    public R handleAccountManager(AccountManagerView accountManager) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleFolder(FolderView folder) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    
}
