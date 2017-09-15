
package view.visitor;

import view.*;

public abstract class RemoteDirectVisitor implements RemoteVisitor {
    
    public abstract void handleServer(ServerView server) throws ModelException;
    
    public abstract void handleService(ServiceView service) throws ModelException;
    
    public void handleDozentenService(DozentenServiceView dozentenService) throws ModelException{
        this.handleService(dozentenService);
    }
    public void handleStudentService(StudentServiceView studentService) throws ModelException{
        this.handleService(studentService);
    }
    
}
