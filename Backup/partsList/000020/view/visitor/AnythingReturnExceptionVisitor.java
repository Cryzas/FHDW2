
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends ComponentReturnExceptionVisitor<R, E> {
    
    public R handleComponentLst(ComponentLstView componentLst) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleQuantifiedComponent(QuantifiedComponentView quantifiedComponent) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    
}
