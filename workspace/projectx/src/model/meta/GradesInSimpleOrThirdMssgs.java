package model.meta;

public interface GradesInSimpleOrThirdMssgs {
    void accept(GradesInSimpleOrThirdMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface GradesInSimpleOrThirdDOWNMssgs extends Mssgs, GradesInSimpleOrThirdMssgs{}
interface GradesInSimpleOrThirdUPMssgs extends GradesInSimpleUPMssgs, GradesInThirdUPMssgs, GradesInSimpleOrThirdMssgs{}
