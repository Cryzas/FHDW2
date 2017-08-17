package model.meta;

public interface StudentManagerMssgs {
    void accept(StudentManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudentManagerDOWNMssgs extends Mssgs, StudentManagerMssgs{}
interface StudentManagerUPMssgs extends Mssgs, StudentManagerMssgs{}
