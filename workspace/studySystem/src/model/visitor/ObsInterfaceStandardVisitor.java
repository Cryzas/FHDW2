
package model.visitor;

import persistence.*;

public abstract class ObsInterfaceStandardVisitor implements ObsInterfaceVisitor {
    
    public void handleStudyGroupServiceGroupManager(StudyGroupServiceGroupManager4Public studyGroupServiceGroupManager) throws PersistenceException{
        this.standardHandling(studyGroupServiceGroupManager);
    }
    public void handleProgramModuleServiceProgramManager(ProgramModuleServiceProgramManager4Public programModuleServiceProgramManager) throws PersistenceException{
        this.standardHandling(programModuleServiceProgramManager);
    }
    public void handleProgramModuleServiceModuleManager(ProgramModuleServiceModuleManager4Public programModuleServiceModuleManager) throws PersistenceException{
        this.standardHandling(programModuleServiceModuleManager);
    }
    public void handleAdminServiceServices(AdminServiceServices4Public adminServiceServices) throws PersistenceException{
        this.standardHandling(adminServiceServices);
    }
    public void handleStudentManageServiceStudentManager(StudentManageServiceStudentManager4Public studentManageServiceStudentManager) throws PersistenceException{
        this.standardHandling(studentManageServiceStudentManager);
    }
    protected abstract void standardHandling(ObsInterface obsInterface) throws PersistenceException;
}
