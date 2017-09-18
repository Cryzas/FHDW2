
package view.visitor;
import view.*;

public interface subAdminServiceReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleDozentenService(DozentenServiceView dozentenService) throws ModelException, E;
    public R handleProgramModuleService(ProgramModuleServiceView programModuleService) throws ModelException, E;
    public R handleStudentManageService(StudentManageServiceView studentManageService) throws ModelException, E;
    public R handleStudyGroupService(StudyGroupServiceView studyGroupService) throws ModelException, E;
    public R handleUserManagerService(UserManagerServiceView userManagerService) throws ModelException, E;
    
}
