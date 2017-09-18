
package view.visitor;
import view.*;

public interface RemoteReturnVisitor<R> extends ServiceReturnVisitor<R> ,subAdminServiceReturnVisitor<R> {
    
    public R handleServer(ServerView server) throws ModelException;
    
}
