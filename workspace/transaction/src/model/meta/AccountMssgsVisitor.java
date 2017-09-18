package model.meta;

public interface AccountMssgsVisitor extends AccountDOWNMssgsVisitor, AccountUPMssgsVisitor {}


interface AccountDOWNMssgsVisitor extends NoAccountDOWNMssgsVisitor {

    public void handleAccountCreditTransferMssg(AccountCreditTransferMssg event) throws persistence.PersistenceException;
    public void handleAccountDebitTransferMssg(AccountDebitTransferMssg event) throws persistence.PersistenceException;
    
}


interface AccountUPMssgsVisitor extends AccountHandleUPMssgsVisitor {

    public void handleAccountCreditTransferMssg(AccountCreditTransferMssg event) throws persistence.PersistenceException;
    public void handleAccountDebitTransferMssg(AccountDebitTransferMssg event) throws persistence.PersistenceException;
    
}
