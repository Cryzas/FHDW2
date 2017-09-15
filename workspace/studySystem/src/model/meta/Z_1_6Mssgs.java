package model.meta;

public interface Z_1_6Mssgs {
    void accept(Z_1_6MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_1_6DOWNMssgs extends GradesInTenthDOWNMssgs, Z_1_6Mssgs{}
interface Z_1_6UPMssgs extends Mssgs, Z_1_6Mssgs{}
