package model.meta;

public interface NoAccountMssgs {
    void accept(NoAccountMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoAccountDOWNMssgs extends AccountDOWNMssgs, NoAccountMssgs{}
interface NoAccountUPMssgs extends Mssgs, NoAccountMssgs{}
