package model.meta;

public interface ThirdGradeMssgs {
    void accept(ThirdGradeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ThirdGradeDOWNMssgs extends GradeSystemDOWNMssgs, ThirdGradeMssgs{}
interface ThirdGradeUPMssgs extends Mssgs, ThirdGradeMssgs{}
