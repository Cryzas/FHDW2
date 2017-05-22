package model.meta;

public interface TransactionMssgs {
    void accept(TransactionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TransactionDOWNMssgs extends BookableDOWNMssgs, TransactionMssgs{}
interface TransactionUPMssgs extends Mssgs, TransactionMssgs{}
