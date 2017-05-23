package model.meta;

public interface DraftMssgs {
    void accept(DraftMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DraftDOWNMssgs extends MailDOWNMssgs, DraftMssgs{}
interface DraftUPMssgs extends Mssgs, DraftMssgs{}
