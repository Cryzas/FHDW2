package model.meta;

public interface GradesInTenthMssgs {
    void accept(GradesInTenthMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface GradesInTenthDOWNMssgs extends Mssgs, GradesInTenthMssgs{}
interface GradesInTenthUPMssgs extends Z_1_0UPMssgs, Z_1_1UPMssgs, Z_3_0UPMssgs, Z_1_2UPMssgs, Z_4_0UPMssgs, Z_2_2UPMssgs, Z_2_3UPMssgs, Z_2_4UPMssgs, Z_2_5UPMssgs, Z_2_6UPMssgs, Z_2_7UPMssgs, Z_2_8UPMssgs, Z_2_9UPMssgs, Z_2_0UPMssgs, Z_2_1UPMssgs, Z_3_1UPMssgs, Z_1_3UPMssgs, Z_5_0UPMssgs, Z_3_2UPMssgs, Z_1_4UPMssgs, Z_3_3UPMssgs, Z_1_5UPMssgs, Z_3_4UPMssgs, Z_1_6UPMssgs, Z_3_5UPMssgs, Z_1_7UPMssgs, Z_3_6UPMssgs, Z_1_8UPMssgs, Z_3_7UPMssgs, Z_1_9UPMssgs, Z_3_8UPMssgs, Z_3_9UPMssgs, NoGradeTenthUPMssgs, GradesInTenthMssgs{}
