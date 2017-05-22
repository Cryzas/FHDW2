
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends ServiceReturnExceptionVisitor<R, E> {
    
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    
}
