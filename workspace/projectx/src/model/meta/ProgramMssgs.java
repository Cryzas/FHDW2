package model.meta;

public interface ProgramMssgs {
    void accept(ProgramMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ProgramDOWNMssgs extends Mssgs, ProgramMssgs{}
interface ProgramUPMssgs extends Mssgs, ProgramMssgs{}
