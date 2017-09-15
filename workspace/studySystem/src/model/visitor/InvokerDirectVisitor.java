
package model.visitor;

import persistence.*;

public abstract class InvokerDirectVisitor implements InvokerVisitor {
    
    public abstract void handleServer(Server4Public server) throws PersistenceException;
    
    public abstract void handleService(Service4Public service) throws PersistenceException;
    
    public void handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException{
        this.handleService(dozentenService);
    }
    public void handleStudentService(StudentService4Public studentService) throws PersistenceException{
        this.handleService(studentService);
    }
    
}
