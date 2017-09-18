package model.meta;

public interface AdminServiceMssgs {
    void accept(AdminServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AdminServiceDOWNMssgs extends ServiceDOWNMssgs, AdminServiceMssgs{}
interface AdminServiceUPMssgs extends Mssgs, AdminServiceMssgs{}
