package model.meta;

public interface TenthGradeMssgs {
    void accept(TenthGradeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TenthGradeDOWNMssgs extends GradeSystemDOWNMssgs, TenthGradeMssgs{}
interface TenthGradeUPMssgs extends Mssgs, TenthGradeMssgs{}
