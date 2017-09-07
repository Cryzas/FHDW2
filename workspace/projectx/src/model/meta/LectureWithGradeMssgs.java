package model.meta;

public interface LectureWithGradeMssgs {
    void accept(LectureWithGradeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface LectureWithGradeDOWNMssgs extends Mssgs, LectureWithGradeMssgs{}
interface LectureWithGradeUPMssgs extends UnitStudentUPMssgs, ModuleAtomarStudentUPMssgs, LectureWithGradeMssgs{}
