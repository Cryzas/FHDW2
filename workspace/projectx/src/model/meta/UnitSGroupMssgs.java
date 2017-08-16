package model.meta;

public interface UnitSGroupMssgs {
    void accept(UnitSGroupMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitSGroupDOWNMssgs extends Mssgs, UnitSGroupMssgs{}
interface UnitSGroupUPMssgs extends Mssgs, UnitSGroupMssgs{}
