package model.meta;

public interface GradeChangeMssgs {
    void accept(GradeChangeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface GradeChangeDOWNMssgs extends Mssgs, GradeChangeMssgs{}
interface GradeChangeUPMssgs extends Mssgs, GradeChangeMssgs{}
