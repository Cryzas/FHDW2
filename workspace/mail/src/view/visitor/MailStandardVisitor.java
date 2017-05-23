
package view.visitor;

import view.*;

public abstract class MailStandardVisitor implements MailVisitor {
    
    public void handleDraft(DraftView draft) throws ModelException{
        this.standardHandling(draft);
    }
    public void handleMailEntry(MailEntryView mailEntry) throws ModelException{
        this.standardHandling(mailEntry);
    }
    protected abstract void standardHandling(MailView mail) throws ModelException;
}
