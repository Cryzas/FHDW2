package model.meta;

public interface AccountMssgs {
    void accept(AccountMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AccountDOWNMssgs extends abstractAccDOWNMssgs, AccountMssgs{}
interface AccountUPMssgs extends Mssgs, AccountMssgs{}
