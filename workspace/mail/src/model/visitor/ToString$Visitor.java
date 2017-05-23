
package model.visitor;

import persistence.*;

public abstract class ToString$Visitor extends AnythingStandardVisitor{
    
    public abstract void handleAccount(Account4Public account) throws PersistenceException;
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    public abstract void handleFolder(Folder4Public folder) throws PersistenceException;
    public abstract void handleAccountWrapper(AccountWrapper4Public accountWrapper) throws PersistenceException;
    public abstract void handleDraft(Draft4Public draft) throws PersistenceException;
    public abstract void handleMailEntry(MailEntry4Public mailEntry) throws PersistenceException;
    public abstract void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    
}
