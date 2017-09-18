package model.meta;

public interface AccountWrpprMssgsVisitor extends AccountWrpprDOWNMssgsVisitor, AccountWrpprUPMssgsVisitor {}


interface AccountWrpprDOWNMssgsVisitor  {

    public void handleAccountWrpprAccountChangedAccountMssg(AccountWrpprAccountChangedAccountMssg event) throws persistence.PersistenceException;
    
}


interface AccountWrpprUPMssgsVisitor extends AccountHandleUPMssgsVisitor {

    public void handleAccountWrpprAccountChangedAccountMssg(AccountWrpprAccountChangedAccountMssg event) throws persistence.PersistenceException;
    
}
