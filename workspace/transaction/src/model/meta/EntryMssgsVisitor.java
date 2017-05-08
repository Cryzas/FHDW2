package model.meta;

public interface EntryMssgsVisitor extends EntryDOWNMssgsVisitor, EntryUPMssgsVisitor {}


interface EntryDOWNMssgsVisitor extends DebitDOWNMssgsVisitor, CreditDOWNMssgsVisitor {

    
}


interface EntryUPMssgsVisitor  {

    
}
