package model.meta;

public interface Z_3_6Mssgs {
    void accept(Z_3_6MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_3_6DOWNMssgs extends GradesInTenthDOWNMssgs, Z_3_6Mssgs{}
interface Z_3_6UPMssgs extends Mssgs, Z_3_6Mssgs{}
