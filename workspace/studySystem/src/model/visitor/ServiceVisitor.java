
package model.visitor;
import persistence.*;

public interface ServiceVisitor {
    
    public void handleAdminService(AdminService4Public adminService) throws PersistenceException;
    public void handleStudentService(StudentService4Public studentService) throws PersistenceException;
    
}
