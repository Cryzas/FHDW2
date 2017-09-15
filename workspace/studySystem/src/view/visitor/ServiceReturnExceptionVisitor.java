
package view.visitor;
import view.*;

public interface ServiceReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleDozentenService(DozentenServiceView dozentenService) throws ModelException, E;
    public R handleStudentService(StudentServiceView studentService) throws ModelException, E;
    
}
