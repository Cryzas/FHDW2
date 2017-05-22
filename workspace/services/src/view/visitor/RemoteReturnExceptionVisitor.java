
package view.visitor;

import view.*;

public interface RemoteReturnExceptionVisitor<R, E extends view.UserException> extends ServiceReturnExceptionVisitor<R, E> {
    
    public R handleServer(ServerView server) throws ModelException, E;
    
}
