
package model.visitor;
import persistence.*;

public interface subAdminServiceVisitor {
    
    public void handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException;
    public void handleProgramModuleService(ProgramModuleService4Public programModuleService) throws PersistenceException;
    public void handleStudentManageService(StudentManageService4Public studentManageService) throws PersistenceException;
    public void handleStudyGroupService(StudyGroupService4Public studyGroupService) throws PersistenceException;
    public void handleUserManagerService(UserManagerService4Public userManagerService) throws PersistenceException;
    
}
