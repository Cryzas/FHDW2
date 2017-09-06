package model.meta;

public interface T_4_0Mssgs {
    void accept(T_4_0MssgsVisitor visitor) throws persistence.PersistenceException;
}

interface T_4_0DOWNMssgs extends GradesInThirdDOWNMssgs, T_4_0Mssgs{}
interface T_4_0UPMssgs extends Mssgs, T_4_0Mssgs{}
