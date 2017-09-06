package model.meta;

public interface NoGradeTenthMssgs {
    void accept(NoGradeTenthMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NoGradeTenthDOWNMssgs extends GradesInTenthDOWNMssgs, NoGradeTenthMssgs{}
interface NoGradeTenthUPMssgs extends Mssgs, NoGradeTenthMssgs{}
