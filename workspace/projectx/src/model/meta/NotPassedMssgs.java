package model.meta;

public interface NotPassedMssgs {
    void accept(NotPassedMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NotPassedDOWNMssgs extends GradesInSimpleDOWNMssgs, NotPassedMssgs{}
interface NotPassedUPMssgs extends Mssgs, NotPassedMssgs{}
