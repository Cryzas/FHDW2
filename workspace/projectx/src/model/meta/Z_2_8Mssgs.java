package model.meta;

public interface Z_2_8Mssgs {
    void accept(Z_2_8MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_2_8DOWNMssgs extends GradesInTenthDOWNMssgs, Z_2_8Mssgs{}
interface Z_2_8UPMssgs extends Mssgs, Z_2_8Mssgs{}
