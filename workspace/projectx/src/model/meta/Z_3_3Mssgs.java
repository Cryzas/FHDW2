package model.meta;

public interface Z_3_3Mssgs {
    void accept(Z_3_3MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_3_3DOWNMssgs extends GradesInTenthDOWNMssgs, Z_3_3Mssgs{}
interface Z_3_3UPMssgs extends Mssgs, Z_3_3Mssgs{}
