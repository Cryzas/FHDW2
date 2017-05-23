
package model.visitor;

import persistence.*;

public interface MailReturnVisitor<R> {
    
    public R handleDraft(Draft4Public draft) throws PersistenceException;
    public R handleMailEntry(MailEntry4Public mailEntry) throws PersistenceException;
    
}
