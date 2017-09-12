
package model.visitor;

import persistence.*;

public abstract class ServiceStandardVisitor implements ServiceVisitor {
    
    public void handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException{
        this.standardHandling(dozentenService);
    }
    public void handleStudentService(StudentService4Public studentService) throws PersistenceException{
        this.standardHandling(studentService);
    }
    protected abstract void standardHandling(Service4Public service) throws PersistenceException;
}
