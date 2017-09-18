package model.meta;

public interface BookedMssgs {
    void accept(BookedMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BookedDOWNMssgs extends TransferStateDOWNMssgs, BookedMssgs{}
interface BookedUPMssgs extends Mssgs, BookedMssgs{}
