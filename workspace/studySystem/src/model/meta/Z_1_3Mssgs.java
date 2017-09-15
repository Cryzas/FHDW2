package model.meta;

public interface Z_1_3Mssgs {
    void accept(Z_1_3MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_1_3DOWNMssgs extends GradesInTenthDOWNMssgs, Z_1_3Mssgs{}
interface Z_1_3UPMssgs extends Mssgs, Z_1_3Mssgs{}
