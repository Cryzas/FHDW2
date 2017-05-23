
package view.visitor;

import view.*;

public interface abstractAccReturnExceptionVisitor<R, E extends view.UserException> {
    
    public R handleAccount(AccountView account) throws ModelException, E;
    public R handleAccountWrapper(AccountWrapperView accountWrapper) throws ModelException, E;
    
}
