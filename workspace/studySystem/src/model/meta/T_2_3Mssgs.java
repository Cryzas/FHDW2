package model.meta;

public interface T_2_3Mssgs {
    void accept(T_2_3MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface T_2_3DOWNMssgs extends GradesInThirdDOWNMssgs, T_2_3Mssgs{}
interface T_2_3UPMssgs extends Mssgs, T_2_3Mssgs{}
