
package view.visitor;

import view.*;

public abstract class RemoteStandardVisitor implements RemoteVisitor {
    
    public void handleStudyGroupService(StudyGroupServiceView studyGroupService) throws ModelException{
        this.standardHandling(studyGroupService);
    }
    public void handleStudentManageService(StudentManageServiceView studentManageService) throws ModelException{
        this.standardHandling(studentManageService);
    }
    public void handleDozentenService(DozentenServiceView dozentenService) throws ModelException{
        this.standardHandling(dozentenService);
    }
    public void handleAdminService(AdminServiceView adminService) throws ModelException{
        this.standardHandling(adminService);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleUserManagerService(UserManagerServiceView userManagerService) throws ModelException{
        this.standardHandling(userManagerService);
    }
    public void handleStudentService(StudentServiceView studentService) throws ModelException{
        this.standardHandling(studentService);
    }
    public void handleProgramModuleService(ProgramModuleServiceView programModuleService) throws ModelException{
        this.standardHandling(programModuleService);
    }
    protected abstract void standardHandling(Remote remote) throws ModelException;
}
