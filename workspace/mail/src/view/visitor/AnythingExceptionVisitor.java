
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> extends MailExceptionVisitor<E>,abstractAccExceptionVisitor<E>{
    
    public void handleAccountManager(AccountManagerView accountManager) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleFolder(FolderView folder) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    
}
