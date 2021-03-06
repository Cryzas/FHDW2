
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends ServiceReturnVisitor<R> {
    
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    
}
