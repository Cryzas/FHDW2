package model.meta;

public interface GradesInThirdMssgs {
    void accept(GradesInThirdMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface GradesInThirdDOWNMssgs extends GradesInSimpleOrThirdDOWNMssgs, GradesInThirdMssgs{}
interface GradesInThirdUPMssgs extends T_3_7UPMssgs, T_2_3UPMssgs, T_4_0UPMssgs, T_2_0UPMssgs, T_2_7UPMssgs, NoGradeUPMssgs, T_5_0UPMssgs, T_1_3UPMssgs, T_3_0UPMssgs, T_1_7UPMssgs, T_3_3UPMssgs, T_1_0UPMssgs, GradesInThirdMssgs{}
