package model.meta;

public interface UnitStudentMssgs {
    void accept(UnitStudentMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitStudentDOWNMssgs extends LectureWithGradeDOWNMssgs, UnitStudentMssgs{}
interface UnitStudentUPMssgs extends Mssgs, UnitStudentMssgs{}
