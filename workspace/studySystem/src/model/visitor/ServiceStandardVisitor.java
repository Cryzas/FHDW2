
package model.visitor;

import persistence.*;

public abstract class ServiceStandardVisitor implements ServiceVisitor {
    
    public void handleAdminService(AdminService4Public adminService) throws PersistenceException{
        this.standardHandling(adminService);
    }
    public void handleStudentService(StudentService4Public studentService) throws PersistenceException{
        this.standardHandling(studentService);
    }
    protected abstract void standardHandling(Service4Public service) throws PersistenceException;
}
