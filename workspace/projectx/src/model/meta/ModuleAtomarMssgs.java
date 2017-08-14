package model.meta;

public interface ModuleAtomarMssgs {
    void accept(ModuleAtomarMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleAtomarDOWNMssgs extends ModuleAbstractDOWNMssgs, ModuleAtomarMssgs{}
interface ModuleAtomarUPMssgs extends Mssgs, ModuleAtomarMssgs{}
