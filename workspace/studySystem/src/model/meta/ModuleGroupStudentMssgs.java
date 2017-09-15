package model.meta;

public interface ModuleGroupStudentMssgs {
    void accept(ModuleGroupStudentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleGroupStudentDOWNMssgs extends ModuleAbstractStudentDOWNMssgs, ModuleGroupStudentMssgs{}
interface ModuleGroupStudentUPMssgs extends Mssgs, ModuleGroupStudentMssgs{}
