
package model.visitor;
import persistence.*;

public interface ServiceExceptionVisitor<E extends model.UserException> {
    
    public void handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException, E;
    public void handleStudentService(StudentService4Public studentService) throws PersistenceException, E;
    
}
