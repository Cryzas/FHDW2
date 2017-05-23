
package model.visitor;

import persistence.*;

public interface MailExceptionVisitor<E extends model.UserException> {
    
    public void handleDraft(Draft4Public draft) throws PersistenceException, E;
    public void handleMailEntry(MailEntry4Public mailEntry) throws PersistenceException, E;
    
}
