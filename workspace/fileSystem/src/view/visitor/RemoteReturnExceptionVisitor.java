
package view.visitor;

import view.*;

public interface RemoteReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleServer(ServerView server) throws ModelException, E;
    
}
