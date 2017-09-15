package model.meta;

public interface ModuleAbstractStudentMssgs {
    void accept(ModuleAbstractStudentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleAbstractStudentDOWNMssgs extends Mssgs, ModuleAbstractStudentMssgs{}
interface ModuleAbstractStudentUPMssgs extends ModuleAtomarStudentUPMssgs, ModuleWithUnitsStudentUPMssgs, ModuleGroupStudentUPMssgs, ModuleAbstractStudentMssgs{}
