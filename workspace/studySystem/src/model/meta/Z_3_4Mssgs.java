package model.meta;

public interface Z_3_4Mssgs {
    void accept(Z_3_4MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_3_4DOWNMssgs extends GradesInTenthDOWNMssgs, Z_3_4Mssgs{}
interface Z_3_4UPMssgs extends Mssgs, Z_3_4Mssgs{}
