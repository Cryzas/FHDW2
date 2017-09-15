package model.meta;

public interface Z_2_6Mssgs {
    void accept(Z_2_6MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_2_6DOWNMssgs extends GradesInTenthDOWNMssgs, Z_2_6Mssgs{}
interface Z_2_6UPMssgs extends Mssgs, Z_2_6Mssgs{}
