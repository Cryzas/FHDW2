
package model.visitor;
import persistence.*;

public interface ObsInterfaceVisitor {
    
    public void handleAdminServiceServices(AdminServiceServices4Public adminServiceServices) throws PersistenceException;
    public void handleProgramModuleServiceModuleManager(ProgramModuleServiceModuleManager4Public programModuleServiceModuleManager) throws PersistenceException;
    public void handleProgramModuleServiceProgramManager(ProgramModuleServiceProgramManager4Public programModuleServiceProgramManager) throws PersistenceException;
    public void handleStudentManageServiceStudentManager(StudentManageServiceStudentManager4Public studentManageServiceStudentManager) throws PersistenceException;
    public void handleStudyGroupServiceGroupManager(StudyGroupServiceGroupManager4Public studyGroupServiceGroupManager) throws PersistenceException;
    
}
