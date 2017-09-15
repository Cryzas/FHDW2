package model.meta;

public interface T_3_7Mssgs {
    void accept(T_3_7MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface T_3_7DOWNMssgs extends GradesInThirdDOWNMssgs, T_3_7Mssgs{}
interface T_3_7UPMssgs extends Mssgs, T_3_7Mssgs{}
