package model.meta;

public interface T_1_7Mssgs {
    void accept(T_1_7MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface T_1_7DOWNMssgs extends GradesInThirdDOWNMssgs, T_1_7Mssgs{}
interface T_1_7UPMssgs extends Mssgs, T_1_7Mssgs{}
