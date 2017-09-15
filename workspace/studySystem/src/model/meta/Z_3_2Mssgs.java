package model.meta;

public interface Z_3_2Mssgs {
    void accept(Z_3_2MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface Z_3_2DOWNMssgs extends GradesInTenthDOWNMssgs, Z_3_2Mssgs{}
interface Z_3_2UPMssgs extends Mssgs, Z_3_2Mssgs{}
