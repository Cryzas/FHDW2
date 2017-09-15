package model.meta;

public interface ModuleAbstractSGroupMssgs {
    void accept(ModuleAbstractSGroupMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleAbstractSGroupDOWNMssgs extends Mssgs, ModuleAbstractSGroupMssgs{}
interface ModuleAbstractSGroupUPMssgs extends ModuleGroupSGroupUPMssgs, ModuleAtomarSGroupUPMssgs, ModuleWithUnitsSGroupUPMssgs, ModuleAbstractSGroupMssgs{}
