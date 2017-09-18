
package view.visitor;
import view.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleAdminService(AdminServiceView adminService) throws ModelException;
    public R handleStudentService(StudentServiceView studentService) throws ModelException;
    
}
