package model.meta;

public interface ModuleAtomarSGroupMssgs {
    void accept(ModuleAtomarSGroupMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleAtomarSGroupDOWNMssgs extends ModuleAbstractSGroupDOWNMssgs, ModuleAtomarSGroupMssgs{}
interface ModuleAtomarSGroupUPMssgs extends Mssgs, ModuleAtomarSGroupMssgs{}
