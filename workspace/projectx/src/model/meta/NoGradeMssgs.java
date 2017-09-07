package model.meta;

public interface NoGradeMssgs {
    void accept(NoGradeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoGradeDOWNMssgs extends GradesInThirdDOWNMssgs, NoGradeMssgs{}
interface NoGradeUPMssgs extends Mssgs, NoGradeMssgs{}
