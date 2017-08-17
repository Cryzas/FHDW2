package model.meta;

public interface UnitStudentMssgs {
    void accept(UnitStudentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitStudentDOWNMssgs extends Mssgs, UnitStudentMssgs{}
interface UnitStudentUPMssgs extends Mssgs, UnitStudentMssgs{}
