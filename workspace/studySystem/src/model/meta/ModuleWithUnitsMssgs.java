package model.meta;

public interface ModuleWithUnitsMssgs {
    void accept(ModuleWithUnitsMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleWithUnitsDOWNMssgs extends ModuleAbstractDOWNMssgs, ModuleWithUnitsMssgs{}
interface ModuleWithUnitsUPMssgs extends Mssgs, ModuleWithUnitsMssgs{}
