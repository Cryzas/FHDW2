
package view.visitor;

import view.*;

public interface AnythingVisitor extends EntryVisitor{
    
    public void handleAccount(AccountView account) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleManager(ManagerView manager) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleTransfer(TransferView transfer) throws ModelException;
    
}
