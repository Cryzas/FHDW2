package model.meta;

public interface ModuleWithUnitsStudentMssgs {
    void accept(ModuleWithUnitsStudentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleWithUnitsStudentDOWNMssgs extends ModuleAbstractStudentDOWNMssgs, ModuleWithUnitsStudentMssgs{}
interface ModuleWithUnitsStudentUPMssgs extends Mssgs, ModuleWithUnitsStudentMssgs{}
