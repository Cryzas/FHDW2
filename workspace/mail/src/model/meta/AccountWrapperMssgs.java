package model.meta;

public interface AccountWrapperMssgs {
    void accept(AccountWrapperMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AccountWrapperDOWNMssgs extends abstractAccDOWNMssgs, AccountWrapperMssgs{}
interface AccountWrapperUPMssgs extends Mssgs, AccountWrapperMssgs{}
