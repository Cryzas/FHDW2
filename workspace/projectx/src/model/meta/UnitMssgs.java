package model.meta;

public interface UnitMssgs {
    void accept(UnitMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitDOWNMssgs extends Mssgs, UnitMssgs{}
interface UnitUPMssgs extends Mssgs, UnitMssgs{}
