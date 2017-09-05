package model.meta;

public interface T_1_0Mssgs {
    void accept(T_1_0MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface T_1_0DOWNMssgs extends GradesInThirdDOWNMssgs, T_1_0Mssgs{}
interface T_1_0UPMssgs extends Mssgs, T_1_0Mssgs{}
