package model.meta;

public interface Z_5_0Mssgs {
    void accept(Z_5_0MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_5_0DOWNMssgs extends GradesInTenthDOWNMssgs, Z_5_0Mssgs{}
interface Z_5_0UPMssgs extends Mssgs, Z_5_0Mssgs{}
