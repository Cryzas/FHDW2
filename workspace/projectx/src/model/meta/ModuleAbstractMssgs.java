package model.meta;

public interface ModuleAbstractMssgs {
    void accept(ModuleAbstractMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleAbstractDOWNMssgs extends Mssgs, ModuleAbstractMssgs{}
interface ModuleAbstractUPMssgs extends ModuleAtomarUPMssgs, ModuleWithUnitsUPMssgs, ModuleAbstractMssgs{}
