
package model.visitor;
import persistence.*;

public interface ServiceReturnVisitor<R> {
    
    public R handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException;
    public R handleStudentService(StudentService4Public studentService) throws PersistenceException;
    
}
