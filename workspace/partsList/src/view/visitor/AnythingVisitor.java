
package view.visitor;

import view.*;

public interface AnythingVisitor extends ComponentVisitor{
    
    public void handleComponentLst(ComponentLstView componentLst) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handlePartsListManager(PartsListManagerView partsListManager) throws ModelException;
    public void handleQuantifiedComponent(QuantifiedComponentView quantifiedComponent) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    
}
