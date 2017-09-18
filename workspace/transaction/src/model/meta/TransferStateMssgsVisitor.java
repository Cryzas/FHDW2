package model.meta;

public interface TransferStateMssgsVisitor extends TransferStateDOWNMssgsVisitor, TransferStateUPMssgsVisitor {}


interface TransferStateDOWNMssgsVisitor extends NotBookedDOWNMssgsVisitor, BookedDOWNMssgsVisitor {

    
}


interface TransferStateUPMssgsVisitor  {

    
}
