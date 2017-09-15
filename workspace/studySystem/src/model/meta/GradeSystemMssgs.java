package model.meta;

public interface GradeSystemMssgs {
    void accept(GradeSystemMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface GradeSystemDOWNMssgs extends Mssgs, GradeSystemMssgs{}
interface GradeSystemUPMssgs extends ThirdGradeSystemUPMssgs, SimpleGradeSystemUPMssgs, GradeSystemMssgs{}
