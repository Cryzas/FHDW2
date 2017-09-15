package model.meta;

public interface Z_1_4Mssgs {
    void accept(Z_1_4MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_1_4DOWNMssgs extends GradesInTenthDOWNMssgs, Z_1_4Mssgs{}
interface Z_1_4UPMssgs extends Mssgs, Z_1_4Mssgs{}
