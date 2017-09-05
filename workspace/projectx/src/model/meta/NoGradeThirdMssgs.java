package model.meta;

public interface NoGradeThirdMssgs {
    void accept(NoGradeThirdMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoGradeThirdDOWNMssgs extends GradesInThirdDOWNMssgs, NoGradeThirdMssgs{}
interface NoGradeThirdUPMssgs extends Mssgs, NoGradeThirdMssgs{}
