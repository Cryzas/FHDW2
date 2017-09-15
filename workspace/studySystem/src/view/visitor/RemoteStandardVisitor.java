
package view.visitor;

import view.*;

public abstract class RemoteStandardVisitor implements RemoteVisitor {
    
    public void handleDozentenService(DozentenServiceView dozentenService) throws ModelException{
        this.standardHandling(dozentenService);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleStudentService(StudentServiceView studentService) throws ModelException{
        this.standardHandling(studentService);
    }
    protected abstract void standardHandling(Remote remote) throws ModelException;
}
