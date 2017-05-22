package model.meta;

public interface BookableMssgsVisitor extends BookableDOWNMssgsVisitor, BookableUPMssgsVisitor {}


interface BookableDOWNMssgsVisitor extends TransactionDOWNMssgsVisitor, TransferDOWNMssgsVisitor {

    
}


interface BookableUPMssgsVisitor  {

    
}
