package model.meta;

public interface Z_1_8Mssgs {
    void accept(Z_1_8MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_1_8DOWNMssgs extends GradesInTenthDOWNMssgs, Z_1_8Mssgs{}
interface Z_1_8UPMssgs extends Mssgs, Z_1_8Mssgs{}
