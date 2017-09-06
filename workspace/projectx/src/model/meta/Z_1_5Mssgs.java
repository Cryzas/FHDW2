package model.meta;

public interface Z_1_5Mssgs {
    void accept(Z_1_5MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_1_5DOWNMssgs extends GradesInTenthDOWNMssgs, Z_1_5Mssgs{}
interface Z_1_5UPMssgs extends Mssgs, Z_1_5Mssgs{}
