package model.meta;

public interface ModuleGroupSGroupMssgs {
    void accept(ModuleGroupSGroupMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleGroupSGroupDOWNMssgs extends ModuleAbstractSGroupDOWNMssgs, ModuleGroupSGroupMssgs{}
interface ModuleGroupSGroupUPMssgs extends Mssgs, ModuleGroupSGroupMssgs{}
