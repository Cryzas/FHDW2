package model.meta;

public interface AccountHandleMssgsVisitor extends AccountHandleDOWNMssgsVisitor, AccountHandleUPMssgsVisitor {}


interface AccountHandleDOWNMssgsVisitor extends AccountDOWNMssgsVisitor, AccountWrpprDOWNMssgsVisitor {

    
}


interface AccountHandleUPMssgsVisitor  {

    
}
