
package view.visitor;
import view.*;

public interface subAdminServiceVisitor {
    
    public void handleDozentenService(DozentenServiceView dozentenService) throws ModelException;
    public void handleProgramModuleService(ProgramModuleServiceView programModuleService) throws ModelException;
    public void handleStudentManageService(StudentManageServiceView studentManageService) throws ModelException;
    public void handleStudyGroupService(StudyGroupServiceView studyGroupService) throws ModelException;
    public void handleUserManagerService(UserManagerServiceView userManagerService) throws ModelException;
    
}
