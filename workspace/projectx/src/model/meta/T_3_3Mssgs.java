package model.meta;

public interface T_3_3Mssgs {
    void accept(T_3_3MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface T_3_3DOWNMssgs extends GradesInThirdDOWNMssgs, T_3_3Mssgs{}
interface T_3_3UPMssgs extends Mssgs, T_3_3Mssgs{}
