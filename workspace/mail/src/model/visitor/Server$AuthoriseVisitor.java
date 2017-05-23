
package model.visitor;

import persistence.*;

public abstract class Server$AuthoriseVisitor extends AnythingStandardVisitor{
    
    public abstract void handleAccount(PersistentAccount account) throws PersistenceException;
    public abstract void handleDraft(PersistentDraft draft) throws PersistenceException;
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public abstract void handleAccountManager(PersistentAccountManager accountManager) throws PersistenceException;
    public abstract void handleMailEntry(PersistentMailEntry mailEntry) throws PersistenceException;
    public abstract void handleFolder(PersistentFolder folder) throws PersistenceException;
    public abstract void handleAccountWrapper(PersistentAccountWrapper accountWrapper) throws PersistenceException;
    
}
