
package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends EntryReturnVisitor<R> {
    
    public R handleAccount(AccountView account) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleManager(ManagerView manager) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleTransfer(TransferView transfer) throws ModelException;
    
}
