
package view.visitor;

import view.*;

public interface MailReturnVisitor<R> {
    
    public R handleDraft(DraftView draft) throws ModelException;
    public R handleMailEntry(MailEntryView mailEntry) throws ModelException;
    
}
