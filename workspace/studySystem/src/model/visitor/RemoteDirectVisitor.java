
package model.visitor;

import persistence.*;

public abstract class RemoteDirectVisitor implements RemoteVisitor {
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleService(Service4Public service) throws PersistenceException;
    
    public void handleAdminService(AdminService4Public adminService) throws PersistenceException{
        this.handleService(adminService);
    }
    public void handleStudentService(StudentService4Public studentService) throws PersistenceException{
        this.handleService(studentService);
    }
    public abstract void handlesubAdminService(subAdminService4Public subAdminService) throws PersistenceException;
    
    public void handleStudyGroupService(StudyGroupService4Public studyGroupService) throws PersistenceException{
        this.handlesubAdminService(studyGroupService);
    }
    public void handleStudentManageService(StudentManageService4Public studentManageService) throws PersistenceException{
        this.handlesubAdminService(studentManageService);
    }
    public void handleUserManagerService(UserManagerService4Public userManagerService) throws PersistenceException{
        this.handlesubAdminService(userManagerService);
    }
    public void handleProgramModuleService(ProgramModuleService4Public programModuleService) throws PersistenceException{
        this.handlesubAdminService(programModuleService);
    }
    
}
