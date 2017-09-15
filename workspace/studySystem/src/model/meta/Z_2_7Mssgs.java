package model.meta;

public interface Z_2_7Mssgs {
    void accept(Z_2_7MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_2_7DOWNMssgs extends GradesInTenthDOWNMssgs, Z_2_7Mssgs{}
interface Z_2_7UPMssgs extends Mssgs, Z_2_7Mssgs{}
