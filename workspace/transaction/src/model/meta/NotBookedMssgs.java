package model.meta;

public interface NotBookedMssgs {
    void accept(NotBookedMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NotBookedDOWNMssgs extends TransferStateDOWNMssgs, NotBookedMssgs{}
interface NotBookedUPMssgs extends Mssgs, NotBookedMssgs{}
