
package view.visitor;
import view.*;

public interface RemoteVisitor extends ServiceVisitor,subAdminServiceVisitor{
    
    public void handleServer(ServerView server) throws ModelException;
    
}
