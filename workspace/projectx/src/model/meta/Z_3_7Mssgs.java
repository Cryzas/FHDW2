package model.meta;

public interface Z_3_7Mssgs {
    void accept(Z_3_7MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_3_7DOWNMssgs extends GradesInTenthDOWNMssgs, Z_3_7Mssgs{}
interface Z_3_7UPMssgs extends Mssgs, Z_3_7Mssgs{}
