package model.meta;

public interface Z_2_0Mssgs {
    void accept(Z_2_0MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_2_0DOWNMssgs extends GradesInTenthDOWNMssgs, Z_2_0Mssgs{}
interface Z_2_0UPMssgs extends Mssgs, Z_2_0Mssgs{}
