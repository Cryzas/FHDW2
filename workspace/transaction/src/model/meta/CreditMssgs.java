package model.meta;

public interface CreditMssgs {
    void accept(CreditMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CreditDOWNMssgs extends EntryDOWNMssgs, CreditMssgs{}
interface CreditUPMssgs extends Mssgs, CreditMssgs{}
