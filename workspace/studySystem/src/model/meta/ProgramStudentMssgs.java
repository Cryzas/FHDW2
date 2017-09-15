package model.meta;

public interface ProgramStudentMssgs {
    void accept(ProgramStudentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ProgramStudentDOWNMssgs extends Mssgs, ProgramStudentMssgs{}
interface ProgramStudentUPMssgs extends NoProgramUPMssgs, ProgramStudentMssgs{}
