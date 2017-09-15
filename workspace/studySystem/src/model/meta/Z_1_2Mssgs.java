package model.meta;

public interface Z_1_2Mssgs {
    void accept(Z_1_2MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_1_2DOWNMssgs extends GradesInTenthDOWNMssgs, Z_1_2Mssgs{}
interface Z_1_2UPMssgs extends Mssgs, Z_1_2Mssgs{}
