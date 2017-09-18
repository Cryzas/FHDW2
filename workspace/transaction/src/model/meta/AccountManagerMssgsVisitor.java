package model.meta;

public interface AccountManagerMssgsVisitor extends AccountManagerDOWNMssgsVisitor, AccountManagerUPMssgsVisitor {}


interface AccountManagerDOWNMssgsVisitor  {

    public void handleAccountManagerAccountChangedAccountMssg(AccountManagerAccountChangedAccountMssg event) throws persistence.PersistenceException;
    
}


interface AccountManagerUPMssgsVisitor  {

    public void handleAccountManagerAccountChangedAccountMssg(AccountManagerAccountChangedAccountMssg event) throws persistence.PersistenceException;
    
}
