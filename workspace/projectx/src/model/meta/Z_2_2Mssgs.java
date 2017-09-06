package model.meta;

public interface Z_2_2Mssgs {
    void accept(Z_2_2MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_2_2DOWNMssgs extends GradesInTenthDOWNMssgs, Z_2_2Mssgs{}
interface Z_2_2UPMssgs extends Mssgs, Z_2_2Mssgs{}
