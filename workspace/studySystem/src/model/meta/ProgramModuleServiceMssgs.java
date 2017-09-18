package model.meta;

public interface ProgramModuleServiceMssgs {
    void accept(ProgramModuleServiceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ProgramModuleServiceDOWNMssgs extends subAdminServiceDOWNMssgs, ProgramModuleServiceMssgs{}
interface ProgramModuleServiceUPMssgs extends Mssgs, ProgramModuleServiceMssgs{}
