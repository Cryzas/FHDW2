package model.meta;

public interface BookedMssgsVisitor extends BookedDOWNMssgsVisitor, BookedUPMssgsVisitor {}


interface BookedDOWNMssgsVisitor  {

    
}


interface BookedUPMssgsVisitor extends TransferStateUPMssgsVisitor {

    
}
