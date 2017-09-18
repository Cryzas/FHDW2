
package view.visitor;
import view.*;

public interface ServiceVisitor {
    
    public void handleAdminService(AdminServiceView adminService) throws ModelException;
    public void handleStudentService(StudentServiceView studentService) throws ModelException;
    
}
