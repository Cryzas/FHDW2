package model.meta;

public interface EntryMssgs {
    void accept(EntryMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface EntryDOWNMssgs extends Mssgs, EntryMssgs{}
interface EntryUPMssgs extends DebitUPMssgs, CreditUPMssgs, EntryMssgs{}
