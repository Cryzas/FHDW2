package model.meta;

public interface UserManagerServiceMssgs {
    void accept(UserManagerServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UserManagerServiceDOWNMssgs extends subAdminServiceDOWNMssgs, UserManagerServiceMssgs{}
interface UserManagerServiceUPMssgs extends Mssgs, UserManagerServiceMssgs{}
