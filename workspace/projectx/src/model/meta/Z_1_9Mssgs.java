package model.meta;

public interface Z_1_9Mssgs {
    void accept(Z_1_9MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_1_9DOWNMssgs extends GradesInTenthDOWNMssgs, Z_1_9Mssgs{}
interface Z_1_9UPMssgs extends Mssgs, Z_1_9Mssgs{}
