package model.meta;

public interface TransferStateMssgs {
    void accept(TransferStateMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TransferStateDOWNMssgs extends Mssgs, TransferStateMssgs{}
interface TransferStateUPMssgs extends NotBookedUPMssgs, BookedUPMssgs, TransferStateMssgs{}
