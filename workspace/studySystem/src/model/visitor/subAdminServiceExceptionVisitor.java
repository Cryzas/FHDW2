
package model.visitor;
import persistence.*;

public interface subAdminServiceExceptionVisitor<E extends model.UserException> {
    
    public void handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException, E;
    public void handleProgramModuleService(ProgramModuleService4Public programModuleService) throws PersistenceException, E;
    public void handleStudentManageService(StudentManageService4Public studentManageService) throws PersistenceException, E;
    public void handleStudyGroupService(StudyGroupService4Public studyGroupService) throws PersistenceException, E;
    public void handleUserManagerService(UserManagerService4Public userManagerService) throws PersistenceException, E;
    
}
