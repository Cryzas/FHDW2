package model.meta;

public interface DebitMssgs {
    void accept(DebitMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DebitDOWNMssgs extends EntryDOWNMssgs, DebitMssgs{}
interface DebitUPMssgs extends Mssgs, DebitMssgs{}
