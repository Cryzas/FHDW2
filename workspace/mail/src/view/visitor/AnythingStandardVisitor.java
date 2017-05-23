
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleAccount(AccountView account) throws ModelException{
        this.standardHandling(account);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleFolder(FolderView folder) throws ModelException{
        this.standardHandling(folder);
    }
    public void handleAccountWrapper(AccountWrapperView accountWrapper) throws ModelException{
        this.standardHandling(accountWrapper);
    }
    public void handleDraft(DraftView draft) throws ModelException{
        this.standardHandling(draft);
    }
    public void handleMailEntry(MailEntryView mailEntry) throws ModelException{
        this.standardHandling(mailEntry);
    }
    public void handleAccountManager(AccountManagerView accountManager) throws ModelException{
        this.standardHandling(accountManager);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}
