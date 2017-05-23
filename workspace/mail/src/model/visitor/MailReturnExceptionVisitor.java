
package model.visitor;

import persistence.*;

public interface MailReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleDraft(Draft4Public draft) throws PersistenceException, E;
    public R handleMailEntry(MailEntry4Public mailEntry) throws PersistenceException, E;
    
}
