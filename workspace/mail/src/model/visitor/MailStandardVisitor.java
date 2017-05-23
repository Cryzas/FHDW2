
package model.visitor;

import persistence.*;

public abstract class MailStandardVisitor implements MailVisitor {
    
    public void handleDraft(Draft4Public draft) throws PersistenceException{
        this.standardHandling(draft);
    }
    public void handleMailEntry(MailEntry4Public mailEntry) throws PersistenceException{
        this.standardHandling(mailEntry);
    }
    protected abstract void standardHandling(Mail4Public mail) throws PersistenceException;
}
