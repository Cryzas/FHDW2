package model.meta;

public interface GradesInSimpleOrThirdMssgs {
    void accept(GradesInSimpleOrThirdMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface GradesInSimpleOrThirdDOWNMssgs extends GradeDOWNMssgs, GradesInSimpleOrThirdMssgs{}
interface GradesInSimpleOrThirdUPMssgs extends GradesInSimpleUPMssgs, GradesInThirdUPMssgs, GradesInSimpleOrThirdMssgs{}
