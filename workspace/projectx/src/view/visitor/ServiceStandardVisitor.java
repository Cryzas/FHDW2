
package view.visitor;

import view.*;

public abstract class ServiceStandardVisitor implements ServiceVisitor {
    
    public void handleDozentenService(DozentenServiceView dozentenService) throws ModelException{
        this.standardHandling(dozentenService);
    }
    public void handleStudentService(StudentServiceView studentService) throws ModelException{
        this.standardHandling(studentService);
    }
    protected abstract void standardHandling(ServiceView service) throws ModelException;
}
