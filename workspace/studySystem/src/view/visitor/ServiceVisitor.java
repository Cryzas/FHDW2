
package view.visitor;
import view.*;

public interface ServiceVisitor {
    
    public void handleDozentenService(DozentenServiceView dozentenService) throws ModelException;
    public void handleStudentService(StudentServiceView studentService) throws ModelException;
    
}
