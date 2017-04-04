
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> {
    
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    
}
