
package view.visitor;

import view.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleMail(MailView mail) throws ModelException;
    
    public void handleDraft(DraftView draft) throws ModelException{
        this.handleMail(draft);
    }
    public void handleMailEntry(MailEntryView mailEntry) throws ModelException{
        this.handleMail(mailEntry);
    }
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    
    public abstract void handleAccountManager(AccountManagerView accountManager) throws ModelException;
    
    public abstract void handleFolder(FolderView folder) throws ModelException;
    
    public abstract void handleabstractAcc(abstractAccView abstractAcc) throws ModelException;
    
    public void handleAccount(AccountView account) throws ModelException{
        this.handleabstractAcc(account);
    }
    public void handleAccountWrapper(AccountWrapperView accountWrapper) throws ModelException{
        this.handleabstractAcc(accountWrapper);
    }
    
}
