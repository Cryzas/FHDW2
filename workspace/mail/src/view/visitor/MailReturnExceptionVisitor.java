
package view.visitor;

import view.*;

public interface MailReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleDraft(DraftView draft) throws ModelException, E;
    public R handleMailEntry(MailEntryView mailEntry) throws ModelException, E;
    
}
