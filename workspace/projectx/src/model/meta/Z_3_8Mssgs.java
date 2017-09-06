package model.meta;

public interface Z_3_8Mssgs {
    void accept(Z_3_8MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_3_8DOWNMssgs extends GradesInTenthDOWNMssgs, Z_3_8Mssgs{}
interface Z_3_8UPMssgs extends Mssgs, Z_3_8Mssgs{}
