package model.meta;

public interface Z_3_0Mssgs {
    void accept(Z_3_0MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_3_0DOWNMssgs extends GradesInTenthDOWNMssgs, Z_3_0Mssgs{}
interface Z_3_0UPMssgs extends Mssgs, Z_3_0Mssgs{}
