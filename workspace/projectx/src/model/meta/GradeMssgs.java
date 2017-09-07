package model.meta;

public interface GradeMssgs {
    void accept(GradeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface GradeDOWNMssgs extends Mssgs, GradeMssgs{}
interface GradeUPMssgs extends GradesInSimpleOrThirdUPMssgs, GradesInTenthUPMssgs, GradeMssgs{}
