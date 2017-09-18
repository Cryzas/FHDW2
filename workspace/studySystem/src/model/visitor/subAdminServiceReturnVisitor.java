
package model.visitor;
import persistence.*;

public interface subAdminServiceReturnVisitor<R> {
    
    public R handleProgramModuleService(ProgramModuleService4Public programModuleService) throws PersistenceException;
    public R handleStudentManageService(StudentManageService4Public studentManageService) throws PersistenceException;
    public R handleStudyGroupService(StudyGroupService4Public studyGroupService) throws PersistenceException;
    public R handleUserManagerService(UserManagerService4Public userManagerService) throws PersistenceException;
    
}
