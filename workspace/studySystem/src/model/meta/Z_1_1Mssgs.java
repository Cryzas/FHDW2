package model.meta;

public interface Z_1_1Mssgs {
    void accept(Z_1_1MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_1_1DOWNMssgs extends GradesInTenthDOWNMssgs, Z_1_1Mssgs{}
interface Z_1_1UPMssgs extends Mssgs, Z_1_1Mssgs{}
