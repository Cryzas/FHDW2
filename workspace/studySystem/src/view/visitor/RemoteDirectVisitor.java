
package view.visitor;

import view.*;

public abstract class RemoteDirectVisitor implements RemoteVisitor {
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleAdminService(AdminServiceView adminService) throws ModelException{
        this.handleService(adminService);
    }
    public void handleStudentService(StudentServiceView studentService) throws ModelException{
        this.handleService(studentService);
    }
    public abstract void handlesubAdminService(subAdminServiceView subAdminService) throws ModelException;
    
    public void handleStudyGroupService(StudyGroupServiceView studyGroupService) throws ModelException{
        this.handlesubAdminService(studyGroupService);
    }
    public void handleStudentManageService(StudentManageServiceView studentManageService) throws ModelException{
        this.handlesubAdminService(studentManageService);
    }
    public void handleDozentenService(DozentenServiceView dozentenService) throws ModelException{
        this.handlesubAdminService(dozentenService);
    }
    public void handleUserManagerService(UserManagerServiceView userManagerService) throws ModelException{
        this.handlesubAdminService(userManagerService);
    }
    public void handleProgramModuleService(ProgramModuleServiceView programModuleService) throws ModelException{
        this.handlesubAdminService(programModuleService);
    }
    
}
