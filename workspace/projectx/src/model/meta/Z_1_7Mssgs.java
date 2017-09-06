package model.meta;

public interface Z_1_7Mssgs {
    void accept(Z_1_7MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_1_7DOWNMssgs extends GradesInTenthDOWNMssgs, Z_1_7Mssgs{}
interface Z_1_7UPMssgs extends Mssgs, Z_1_7Mssgs{}
