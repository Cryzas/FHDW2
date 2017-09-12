
package model.visitor;
import persistence.*;

public interface ServiceReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException, E;
    public R handleStudentService(StudentService4Public studentService) throws PersistenceException, E;
    
}
