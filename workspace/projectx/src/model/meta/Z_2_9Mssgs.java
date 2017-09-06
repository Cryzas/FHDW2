package model.meta;

public interface Z_2_9Mssgs {
    void accept(Z_2_9MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_2_9DOWNMssgs extends GradesInTenthDOWNMssgs, Z_2_9Mssgs{}
interface Z_2_9UPMssgs extends Mssgs, Z_2_9Mssgs{}
