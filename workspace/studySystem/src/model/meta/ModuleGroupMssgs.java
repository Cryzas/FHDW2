package model.meta;

public interface ModuleGroupMssgs {
    void accept(ModuleGroupMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleGroupDOWNMssgs extends ModuleAbstractDOWNMssgs, ModuleGroupMssgs{}
interface ModuleGroupUPMssgs extends Mssgs, ModuleGroupMssgs{}
