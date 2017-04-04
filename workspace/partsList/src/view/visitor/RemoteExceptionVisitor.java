
package view.visitor;

import view.*;

public interface RemoteExceptionVisitor<E extends view.UserException> {
    
    public void handleServer(ServerView server) throws ModelException, E;
    
}
