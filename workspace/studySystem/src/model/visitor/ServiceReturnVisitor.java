
package model.visitor;
import persistence.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleAdminService(AdminService4Public adminService) throws PersistenceException;
    public R handleStudentService(StudentService4Public studentService) throws PersistenceException;
    
}
