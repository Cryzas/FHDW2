
package view.visitor;
import view.*;

public interface ServiceExceptionVisitor<E extends view.UserException> {
    
    public void handleDozentenService(DozentenServiceView dozentenService) throws ModelException, E;
    public void handleStudentService(StudentServiceView studentService) throws ModelException, E;
    
}
