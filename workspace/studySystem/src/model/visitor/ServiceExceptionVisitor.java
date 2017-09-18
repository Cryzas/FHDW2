
package model.visitor;
import persistence.*;

public interface ServiceExceptionVisitor<E extends model.UserException> {
    
    public void handleAdminService(AdminService4Public adminService) throws PersistenceException, E;
    public void handleStudentService(StudentService4Public studentService) throws PersistenceException, E;
    
}
