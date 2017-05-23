
package view.visitor;

import view.*;

public interface AnythingVisitor extends MailVisitor,abstractAccVisitor{
    
    public void handleAccountManager(AccountManagerView accountManager) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleFolder(FolderView folder) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    
}
