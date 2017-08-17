package model.meta;

public interface ModuleAtomarStudentMssgs {
    void accept(ModuleAtomarStudentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleAtomarStudentDOWNMssgs extends ModuleAbstractStudentDOWNMssgs, ModuleAtomarStudentMssgs{}
interface ModuleAtomarStudentUPMssgs extends Mssgs, ModuleAtomarStudentMssgs{}
