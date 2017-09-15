package model.meta;

public interface Z_3_5Mssgs {
    void accept(Z_3_5MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_3_5DOWNMssgs extends GradesInTenthDOWNMssgs, Z_3_5Mssgs{}
interface Z_3_5UPMssgs extends Mssgs, Z_3_5Mssgs{}
