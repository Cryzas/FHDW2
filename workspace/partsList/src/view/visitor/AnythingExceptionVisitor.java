
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> extends ComponentExceptionVisitor<E>{
    
    public void handleComponentLst(ComponentLstView componentLst) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handlePartsListManager(PartsListManagerView partsListManager) throws ModelException, E;
    public void handleQuantifiedComponent(QuantifiedComponentView quantifiedComponent) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    
}
