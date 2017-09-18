package model.meta;

public interface StudentManageServiceMssgs {
    void accept(StudentManageServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface StudentManageServiceDOWNMssgs extends subAdminServiceDOWNMssgs, StudentManageServiceMssgs{}
interface StudentManageServiceUPMssgs extends Mssgs, StudentManageServiceMssgs{}
