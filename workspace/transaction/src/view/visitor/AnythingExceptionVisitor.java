
package view.visitor;

import view.*;

public interface AnythingExceptionVisitor<E extends view.UserException> extends EntryExceptionVisitor<E>{
    
    public void handleAccount(AccountView account) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleManager(ManagerView manager) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleTransfer(TransferView transfer) throws ModelException, E;
    
}
