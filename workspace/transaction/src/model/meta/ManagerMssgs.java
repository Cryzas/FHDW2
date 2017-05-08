package model.meta;

public interface ManagerMssgs {
    void accept(ManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ManagerDOWNMssgs extends Mssgs, ManagerMssgs{}
interface ManagerUPMssgs extends Mssgs, ManagerMssgs{}
