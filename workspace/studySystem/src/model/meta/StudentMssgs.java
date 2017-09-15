package model.meta;

public interface StudentMssgs {
    void accept(StudentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudentDOWNMssgs extends Mssgs, StudentMssgs{}
interface StudentUPMssgs extends Mssgs, StudentMssgs{}
