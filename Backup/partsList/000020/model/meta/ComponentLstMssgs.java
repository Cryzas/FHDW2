package model.meta;

public interface ComponentLstMssgs {
    void accept(ComponentLstMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ComponentLstDOWNMssgs extends Mssgs, ComponentLstMssgs{}
interface ComponentLstUPMssgs extends Mssgs, ComponentLstMssgs{}
