package model.meta;

public interface Z_3_9Mssgs {
    void accept(Z_3_9MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_3_9DOWNMssgs extends GradesInTenthDOWNMssgs, Z_3_9Mssgs{}
interface Z_3_9UPMssgs extends Mssgs, Z_3_9Mssgs{}
