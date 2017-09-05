package model.meta;

public interface T_1_3Mssgs {
    void accept(T_1_3MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface T_1_3DOWNMssgs extends GradesInThirdDOWNMssgs, T_1_3Mssgs{}
interface T_1_3UPMssgs extends Mssgs, T_1_3Mssgs{}
