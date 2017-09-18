
package model.visitor;
import persistence.*;

public interface ObsInterfaceReturnVisitor<R> {
    
    public R handleAdminServiceServices(AdminServiceServices4Public adminServiceServices) throws PersistenceException;
    public R handleProgramModuleServiceModuleManager(ProgramModuleServiceModuleManager4Public programModuleServiceModuleManager) throws PersistenceException;
    public R handleProgramModuleServiceProgramManager(ProgramModuleServiceProgramManager4Public programModuleServiceProgramManager) throws PersistenceException;
    public R handleStudentManageServiceStudentManager(StudentManageServiceStudentManager4Public studentManageServiceStudentManager) throws PersistenceException;
    public R handleStudyGroupServiceGroupManager(StudyGroupServiceGroupManager4Public studyGroupServiceGroupManager) throws PersistenceException;
    
}
