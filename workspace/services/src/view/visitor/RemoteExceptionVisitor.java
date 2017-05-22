
package view.visitor;

import view.*;

public interface RemoteExceptionVisitor<E extends view.UserException> extends ServiceExceptionVisitor<E>{
    
    public void handleServer(ServerView server) throws ModelException, E;
    
}
