package model.meta;

public interface AccountWrpprMssgs {
    void accept(AccountWrpprMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AccountWrpprDOWNMssgs extends AccountHandleDOWNMssgs, AccountWrpprMssgs{}
interface AccountWrpprUPMssgs extends Mssgs, AccountWrpprMssgs{}
