package model.meta;

public interface ModuleWithUnitsSGroupMssgs {
    void accept(ModuleWithUnitsSGroupMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleWithUnitsSGroupDOWNMssgs extends ModuleAbstractSGroupDOWNMssgs, ModuleWithUnitsSGroupMssgs{}
interface ModuleWithUnitsSGroupUPMssgs extends Mssgs, ModuleWithUnitsSGroupMssgs{}
