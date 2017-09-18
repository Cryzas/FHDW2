package model.meta;

public interface NotBookedMssgsVisitor extends NotBookedDOWNMssgsVisitor, NotBookedUPMssgsVisitor {}


interface NotBookedDOWNMssgsVisitor  {

    
}


interface NotBookedUPMssgsVisitor extends TransferStateUPMssgsVisitor {

    
}
