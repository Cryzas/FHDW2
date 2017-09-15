package model.meta;

public interface ThirdGradeSystemMssgs {
    void accept(ThirdGradeSystemMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ThirdGradeSystemDOWNMssgs extends GradeSystemDOWNMssgs, ThirdGradeSystemMssgs{}
interface ThirdGradeSystemUPMssgs extends Mssgs, ThirdGradeSystemMssgs{}
