package model.meta;

public interface UserManagerMssgs {
    void accept(UserManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UserManagerDOWNMssgs extends ServiceDOWNMssgs, UserManagerMssgs{}
interface UserManagerUPMssgs extends Mssgs, UserManagerMssgs{}
