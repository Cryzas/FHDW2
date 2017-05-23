package model.meta;

public interface MailMssgsVisitor extends MailDOWNMssgsVisitor, MailUPMssgsVisitor {}


interface MailDOWNMssgsVisitor extends DraftDOWNMssgsVisitor, MailEntryDOWNMssgsVisitor {

    
}


interface MailUPMssgsVisitor  {

    
}
