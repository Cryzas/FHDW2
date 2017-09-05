package model.meta;

public interface T_2_0Mssgs {
    void accept(T_2_0MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface T_2_0DOWNMssgs extends GradesInThirdDOWNMssgs, T_2_0Mssgs{}
interface T_2_0UPMssgs extends Mssgs, T_2_0Mssgs{}
