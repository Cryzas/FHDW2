
package view.visitor;
import view.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleDozentenService(DozentenServiceView dozentenService) throws ModelException;
    public R handleStudentService(StudentServiceView studentService) throws ModelException;
    
}
