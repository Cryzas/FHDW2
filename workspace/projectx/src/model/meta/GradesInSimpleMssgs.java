package model.meta;

public interface GradesInSimpleMssgs {
    void accept(GradesInSimpleMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface GradesInSimpleDOWNMssgs extends GradesInSimpleOrThirdDOWNMssgs, GradesInSimpleMssgs{}
interface GradesInSimpleUPMssgs extends PassedUPMssgs, NoGradeSimpleUPMssgs, NotPassedUPMssgs, GradesInSimpleMssgs{}
