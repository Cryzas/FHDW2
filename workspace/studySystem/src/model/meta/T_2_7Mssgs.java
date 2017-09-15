package model.meta;

public interface T_2_7Mssgs {
    void accept(T_2_7MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface T_2_7DOWNMssgs extends GradesInThirdDOWNMssgs, T_2_7Mssgs{}
interface T_2_7UPMssgs extends Mssgs, T_2_7Mssgs{}
