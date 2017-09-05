package model.meta;

public interface GradesInThirdMssgs {
    void accept(GradesInThirdMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface GradesInThirdDOWNMssgs extends Mssgs, GradesInThirdMssgs{}
interface GradesInThirdUPMssgs extends NoGradeThirdUPMssgs, T_2_3UPMssgs, T_1_3UPMssgs, T_2_0UPMssgs, T_1_7UPMssgs, T_1_0UPMssgs, GradesInThirdMssgs{}