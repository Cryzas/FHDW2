package model.meta;

public interface BookableMssgs {
    void accept(BookableMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BookableDOWNMssgs extends Mssgs, BookableMssgs{}
interface BookableUPMssgs extends TransactionUPMssgs, TransferUPMssgs, BookableMssgs{}
