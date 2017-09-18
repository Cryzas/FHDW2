package model.meta;

public interface subAdminServiceMssgsVisitor extends subAdminServiceDOWNMssgsVisitor, subAdminServiceUPMssgsVisitor {}


interface subAdminServiceDOWNMssgsVisitor extends StudentManageServiceDOWNMssgsVisitor, UserManagerServiceDOWNMssgsVisitor, ProgramModuleServiceDOWNMssgsVisitor, StudyGroupServiceDOWNMssgsVisitor {

    public void handlesubAdminServiceUpdatePLZMssg(subAdminServiceUpdatePLZMssg event) throws persistence.PersistenceException;
    
}


interface subAdminServiceUPMssgsVisitor  {

    public void handlesubAdminServiceUpdatePLZMssg(subAdminServiceUpdatePLZMssg event) throws persistence.PersistenceException;
    
}
