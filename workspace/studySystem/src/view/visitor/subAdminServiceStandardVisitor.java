
package view.visitor;

import view.*;

public abstract class subAdminServiceStandardVisitor implements subAdminServiceVisitor {
    
    public void handleStudyGroupService(StudyGroupServiceView studyGroupService) throws ModelException{
        this.standardHandling(studyGroupService);
    }
    public void handleStudentManageService(StudentManageServiceView studentManageService) throws ModelException{
        this.standardHandling(studentManageService);
    }
    public void handleDozentenService(DozentenServiceView dozentenService) throws ModelException{
        this.standardHandling(dozentenService);
    }
    public void handleUserManagerService(UserManagerServiceView userManagerService) throws ModelException{
        this.standardHandling(userManagerService);
    }
    public void handleProgramModuleService(ProgramModuleServiceView programModuleService) throws ModelException{
        this.standardHandling(programModuleService);
    }
    protected abstract void standardHandling(subAdminServiceView subAdminService) throws ModelException;
}
