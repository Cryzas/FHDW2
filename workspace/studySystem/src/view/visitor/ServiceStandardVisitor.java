
package view.visitor;

import view.*;

public abstract class ServiceStandardVisitor implements ServiceVisitor {
    
    public void handleAdminService(AdminServiceView adminService) throws ModelException{
        this.standardHandling(adminService);
    }
    public void handleStudentService(StudentServiceView studentService) throws ModelException{
        this.standardHandling(studentService);
    }
    protected abstract void standardHandling(ServiceView service) throws ModelException;
}
