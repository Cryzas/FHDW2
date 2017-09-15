package model.meta;

public interface NoProgramMssgs {
    void accept(NoProgramMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoProgramDOWNMssgs extends ProgramStudentDOWNMssgs, NoProgramMssgs{}
interface NoProgramUPMssgs extends Mssgs, NoProgramMssgs{}
