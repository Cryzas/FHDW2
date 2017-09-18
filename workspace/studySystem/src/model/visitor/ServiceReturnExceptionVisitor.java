
package model.visitor;
import persistence.*;

public interface ServiceReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleAdminService(AdminService4Public adminService) throws PersistenceException, E;
    public R handleStudentService(StudentService4Public studentService) throws PersistenceException, E;
    
}
