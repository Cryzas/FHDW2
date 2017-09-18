
package view.visitor;
import view.*;

public interface subAdminServiceReturnVisitor<R> {
    
    public R handleDozentenService(DozentenServiceView dozentenService) throws ModelException;
    public R handleProgramModuleService(ProgramModuleServiceView programModuleService) throws ModelException;
    public R handleStudentManageService(StudentManageServiceView studentManageService) throws ModelException;
    public R handleStudyGroupService(StudyGroupServiceView studyGroupService) throws ModelException;
    public R handleUserManagerService(UserManagerServiceView userManagerService) throws ModelException;
    
}
