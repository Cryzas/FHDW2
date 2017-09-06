package model.meta;

public interface Z_2_1Mssgs {
    void accept(Z_2_1MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_2_1DOWNMssgs extends GradesInTenthDOWNMssgs, Z_2_1Mssgs{}
interface Z_2_1UPMssgs extends Mssgs, Z_2_1Mssgs{}
