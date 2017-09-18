
package view.visitor;
import view.*;

public interface ServiceExceptionVisitor<E extends view.UserException> {
    
    public void handleAdminService(AdminServiceView adminService) throws ModelException, E;
    public void handleStudentService(StudentServiceView studentService) throws ModelException, E;
    
}
