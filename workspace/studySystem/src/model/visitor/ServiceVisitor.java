
package model.visitor;
import persistence.*;

public interface ServiceVisitor {
    
    public void handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException;
    public void handleStudentService(StudentService4Public studentService) throws PersistenceException;
    
}
