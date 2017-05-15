package model.meta;

public interface AccountManagerMssgsVisitor extends AccountManagerDOWNMssgsVisitor, AccountManagerUPMssgsVisitor {}


interface AccountManagerDOWNMssgsVisitor  {

    public void handleAccountManagerAccountChangedMssg(AccountManagerAccountChangedMssg event) throws persistence.PersistenceException;
    
}


interface AccountManagerUPMssgsVisitor  {

    public void handleAccountManagerAccountChangedMssg(AccountManagerAccountChangedMssg event) throws persistence.PersistenceException;
    
}
