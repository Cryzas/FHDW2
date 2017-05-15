package model.meta;

public interface TransferManagerMssgs {
    void accept(TransferManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TransferManagerDOWNMssgs extends Mssgs, TransferManagerMssgs{}
interface TransferManagerUPMssgs extends Mssgs, TransferManagerMssgs{}
