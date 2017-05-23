
package model.visitor;

import persistence.*;

public interface MailVisitor {
    
    public void handleDraft(Draft4Public draft) throws PersistenceException;
    public void handleMailEntry(MailEntry4Public mailEntry) throws PersistenceException;
    
}
