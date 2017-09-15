package model.meta;

public interface Z_2_4Mssgs {
    void accept(Z_2_4MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_2_4DOWNMssgs extends GradesInTenthDOWNMssgs, Z_2_4Mssgs{}
interface Z_2_4UPMssgs extends Mssgs, Z_2_4Mssgs{}
