package model.meta;

public interface DozentenServiceMssgs {
    void accept(DozentenServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DozentenServiceDOWNMssgs extends subAdminServiceDOWNMssgs, DozentenServiceMssgs{}
interface DozentenServiceUPMssgs extends Mssgs, DozentenServiceMssgs{}
