package model.meta;

public interface T_3_0Mssgs {
    void accept(T_3_0MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface T_3_0DOWNMssgs extends GradesInThirdDOWNMssgs, T_3_0Mssgs{}
interface T_3_0UPMssgs extends Mssgs, T_3_0Mssgs{}
