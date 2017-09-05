package model.meta;

public interface SimpleGradeSystemMssgs {
    void accept(SimpleGradeSystemMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface SimpleGradeSystemDOWNMssgs extends GradeSystemDOWNMssgs, SimpleGradeSystemMssgs{}
interface SimpleGradeSystemUPMssgs extends Mssgs, SimpleGradeSystemMssgs{}
