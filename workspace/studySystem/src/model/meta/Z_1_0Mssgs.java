package model.meta;

public interface Z_1_0Mssgs {
    void accept(Z_1_0MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_1_0DOWNMssgs extends GradesInTenthDOWNMssgs, Z_1_0Mssgs{}
interface Z_1_0UPMssgs extends Mssgs, Z_1_0Mssgs{}
