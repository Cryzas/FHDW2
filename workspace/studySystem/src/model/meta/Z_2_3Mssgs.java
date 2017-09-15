package model.meta;

public interface Z_2_3Mssgs {
    void accept(Z_2_3MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_2_3DOWNMssgs extends GradesInTenthDOWNMssgs, Z_2_3Mssgs{}
interface Z_2_3UPMssgs extends Mssgs, Z_2_3Mssgs{}
