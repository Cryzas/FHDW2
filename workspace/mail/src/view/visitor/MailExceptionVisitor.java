
package view.visitor;

import view.*;

public interface MailExceptionVisitor<E extends view.UserException> {
    
    public void handleDraft(DraftView draft) throws ModelException, E;
    public void handleMailEntry(MailEntryView mailEntry) throws ModelException, E;
    
}
