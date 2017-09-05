package model.meta;

public interface NoGradeSimpleMssgs {
    void accept(NoGradeSimpleMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoGradeSimpleDOWNMssgs extends GradesInSimpleDOWNMssgs, NoGradeSimpleMssgs{}
interface NoGradeSimpleUPMssgs extends Mssgs, NoGradeSimpleMssgs{}
