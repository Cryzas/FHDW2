package model.meta;

public interface Z_3_1Mssgs {
    void accept(Z_3_1MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_3_1DOWNMssgs extends GradesInTenthDOWNMssgs, Z_3_1Mssgs{}
interface Z_3_1UPMssgs extends Mssgs, Z_3_1Mssgs{}
