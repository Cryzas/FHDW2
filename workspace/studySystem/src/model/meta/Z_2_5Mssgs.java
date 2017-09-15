package model.meta;

public interface Z_2_5Mssgs {
    void accept(Z_2_5MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_2_5DOWNMssgs extends GradesInTenthDOWNMssgs, Z_2_5Mssgs{}
interface Z_2_5UPMssgs extends Mssgs, Z_2_5Mssgs{}
