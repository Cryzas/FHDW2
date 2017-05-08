
package view.visitor;

import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends view.UserException> extends EntryReturnExceptionVisitor<R, E> {
    
    public R handleAccount(AccountView account) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleManager(ManagerView manager) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleTransfer(TransferView transfer) throws ModelException, E;
    
}
