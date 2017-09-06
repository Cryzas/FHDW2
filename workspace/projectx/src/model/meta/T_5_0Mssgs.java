package model.meta;

public interface T_5_0Mssgs {
    void accept(T_5_0MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface T_5_0DOWNMssgs extends GradesInThirdDOWNMssgs, T_5_0Mssgs{}
interface T_5_0UPMssgs extends Mssgs, T_5_0Mssgs{}
