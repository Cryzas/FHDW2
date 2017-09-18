
package view.visitor;
import view.*;

public interface subAdminServiceExceptionVisitor<E extends view.UserException> {
    
    public void handleDozentenService(DozentenServiceView dozentenService) throws ModelException, E;
    public void handleProgramModuleService(ProgramModuleServiceView programModuleService) throws ModelException, E;
    public void handleStudentManageService(StudentManageServiceView studentManageService) throws ModelException, E;
    public void handleStudyGroupService(StudyGroupServiceView studyGroupService) throws ModelException, E;
    public void handleUserManagerService(UserManagerServiceView userManagerService) throws ModelException, E;
    
}
