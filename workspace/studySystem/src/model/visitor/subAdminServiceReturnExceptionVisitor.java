
package model.visitor;
import persistence.*;

public interface subAdminServiceReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleProgramModuleService(ProgramModuleService4Public programModuleService) throws PersistenceException, E;
    public R handleStudentManageService(StudentManageService4Public studentManageService) throws PersistenceException, E;
    public R handleStudyGroupService(StudyGroupService4Public studyGroupService) throws PersistenceException, E;
    public R handleUserManagerService(UserManagerService4Public userManagerService) throws PersistenceException, E;
    
}
