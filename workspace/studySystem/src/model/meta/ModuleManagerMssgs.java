package model.meta;

public interface ModuleManagerMssgs {
    void accept(ModuleManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleManagerDOWNMssgs extends Mssgs, ModuleManagerMssgs{}
interface ModuleManagerUPMssgs extends Mssgs, ModuleManagerMssgs{}
