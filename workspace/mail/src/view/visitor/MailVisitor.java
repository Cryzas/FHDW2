
package view.visitor;

import view.*;

public interface MailVisitor {
    
    public void handleDraft(DraftView draft) throws ModelException;
    public void handleMailEntry(MailEntryView mailEntry) throws ModelException;
    
}
