package model.meta;

public interface AccountHandleMssgs {
    void accept(AccountHandleMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AccountHandleDOWNMssgs extends Mssgs, AccountHandleMssgs{}
interface AccountHandleUPMssgs extends AccountUPMssgs, AccountWrpprUPMssgs, AccountHandleMssgs{}
