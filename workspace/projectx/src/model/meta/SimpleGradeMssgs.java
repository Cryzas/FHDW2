package model.meta;

public interface SimpleGradeMssgs {
    void accept(SimpleGradeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface SimpleGradeDOWNMssgs extends GradeSystemDOWNMssgs, SimpleGradeMssgs{}
interface SimpleGradeUPMssgs extends Mssgs, SimpleGradeMssgs{}
