package model.meta;

public interface ModuleAtomarStudentMssgs {
    void accept(ModuleAtomarStudentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ModuleAtomarStudentDOWNMssgs extends ModuleAbstractStudentDOWNMssgs, LectureWithGradeDOWNMssgs, ModuleAtomarStudentMssgs{}
interface ModuleAtomarStudentUPMssgs extends Mssgs, ModuleAtomarStudentMssgs{}
