
package model.visitor;

import persistence.*;

public abstract class InvokerStandardVisitor implements InvokerVisitor {
    
    public void handleDozentenService(DozentenService4Public dozentenService) throws PersistenceException{
        this.standardHandling(dozentenService);
    }
    public void handleServer(Server4Public server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleStudentService(StudentService4Public studentService) throws PersistenceException{
        this.standardHandling(studentService);
    }
    protected abstract void standardHandling(Invoker invoker) throws PersistenceException;
}
