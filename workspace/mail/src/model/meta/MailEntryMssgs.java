package model.meta;

public interface MailEntryMssgs {
    void accept(MailEntryMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MailEntryDOWNMssgs extends MailDOWNMssgs, MailEntryMssgs{}
interface MailEntryUPMssgs extends Mssgs, MailEntryMssgs{}
