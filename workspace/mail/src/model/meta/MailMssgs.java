package model.meta;

public interface MailMssgs {
    void accept(MailMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MailDOWNMssgs extends Mssgs, MailMssgs{}
interface MailUPMssgs extends DraftUPMssgs, MailEntryUPMssgs, MailMssgs{}
