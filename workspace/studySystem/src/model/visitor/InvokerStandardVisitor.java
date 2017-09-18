
package model.visitor;

import persistence.*;

public abstract class InvokerStandardVisitor implements InvokerVisitor {
    
    public void handleStudyGroupService(StudyGroupService4Public studyGroupService) throws PersistenceException{
        this.standardHandling(studyGroupService);
    }
    public void handleStudentManageService(StudentManageService4Public studentManageService) throws PersistenceException{
        this.standardHandling(studentManageService);
    }
    public void handleAdminService(AdminService4Public adminService) throws PersistenceException{
        this.standardHandling(adminService);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleUserManagerService(UserManagerService4Public userManagerService) throws PersistenceException{
        this.standardHandling(userManagerService);
    }
    public void handleStudentService(StudentService4Public studentService) throws PersistenceException{
        this.standardHandling(studentService);
    }
    public void handleProgramModuleService(ProgramModuleService4Public programModuleService) throws PersistenceException{
        this.standardHandling(programModuleService);
    }
    protected abstract void standardHandling(Invoker invoker) throws PersistenceException;
}
