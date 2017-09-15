package model.meta;

public interface StudentServiceMssgs {
    void accept(StudentServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudentServiceDOWNMssgs extends ServiceDOWNMssgs, StudentServiceMssgs{}
interface StudentServiceUPMssgs extends Mssgs, StudentServiceMssgs{}
