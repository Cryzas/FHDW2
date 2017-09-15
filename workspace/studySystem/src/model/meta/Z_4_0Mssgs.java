package model.meta;

public interface Z_4_0Mssgs {
    void accept(Z_4_0MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_4_0DOWNMssgs extends GradesInTenthDOWNMssgs, Z_4_0Mssgs{}
interface Z_4_0UPMssgs extends Mssgs, Z_4_0Mssgs{}
