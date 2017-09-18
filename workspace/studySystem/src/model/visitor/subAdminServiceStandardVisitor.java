
package model.visitor;

import persistence.*;

public abstract class subAdminServiceStandardVisitor implements subAdminServiceVisitor {
    
    public void handleStudyGroupService(StudyGroupService4Public studyGroupService) throws PersistenceException{
        this.standardHandling(studyGroupService);
    }
    public void handleStudentManageService(StudentManageService4Public studentManageService) throws PersistenceException{
        this.standardHandling(studentManageService);
    }
    public void handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException{
        this.standardHandling(dozentenService);
    }
    public void handleUserManagerService(UserManagerService4Public userManagerService) throws PersistenceException{
        this.standardHandling(userManagerService);
    }
    public void handleProgramModuleService(ProgramModuleService4Public programModuleService) throws PersistenceException{
        this.standardHandling(programModuleService);
    }
    protected abstract void standardHandling(subAdminService4Public subAdminService) throws PersistenceException;
}
