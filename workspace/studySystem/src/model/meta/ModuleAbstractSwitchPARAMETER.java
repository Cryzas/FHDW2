package model.meta;

public interface ModuleAbstractSwitchPARAMETER{
    persistence.ModuleAtomar4Public handleModuleAtomar() throws persistence.PersistenceException;
    persistence.ModuleWithUnits4Public handleModuleWithUnits() throws persistence.PersistenceException;
    persistence.ModuleGroup4Public handleModuleGroup() throws persistence.PersistenceException;
}
