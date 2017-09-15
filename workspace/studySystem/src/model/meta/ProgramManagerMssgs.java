package model.meta;

public interface ProgramManagerMssgs {
    void accept(ProgramManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ProgramManagerDOWNMssgs extends Mssgs, ProgramManagerMssgs{}
interface ProgramManagerUPMssgs extends Mssgs, ProgramManagerMssgs{}
