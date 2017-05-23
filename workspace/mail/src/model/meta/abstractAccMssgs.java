package model.meta;

public interface abstractAccMssgs {
    void accept(abstractAccMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface abstractAccDOWNMssgs extends Mssgs, abstractAccMssgs{}
interface abstractAccUPMssgs extends AccountUPMssgs, AccountWrapperUPMssgs, abstractAccMssgs{}
