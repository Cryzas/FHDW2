
package view.visitor;
import view.*;

public interface AnythingReturnVisitor<R> extends ComponentReturnVisitor<R> {
    
    public R handleComponentLst(ComponentLstView componentLst) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handlePartsListManager(PartsListManagerView partsListManager) throws ModelException;
    public R handleQuantifiedComponent(QuantifiedComponentView quantifiedComponent) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    
}
