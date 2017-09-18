package model.meta;

public interface AbstractTransferMssgs {
    void accept(AbstractTransferMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AbstractTransferDOWNMssgs extends Mssgs, AbstractTransferMssgs{}
interface AbstractTransferUPMssgs extends TransferUPMssgs, AbstractTransferMssgs{}
