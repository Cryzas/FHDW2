package model.meta;

public interface subAdminServiceMssgs {
    void accept(subAdminServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface subAdminServiceDOWNMssgs extends Mssgs, subAdminServiceMssgs{}
interface subAdminServiceUPMssgs extends StudentManageServiceUPMssgs, DozentenServiceUPMssgs, UserManagerServiceUPMssgs, ProgramModuleServiceUPMssgs, StudyGroupServiceUPMssgs, subAdminServiceMssgs{}
