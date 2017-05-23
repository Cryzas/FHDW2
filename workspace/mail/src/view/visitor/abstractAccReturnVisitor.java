
package view.visitor;

import view.*;

public interface abstractAccReturnVisitor<R> {
    
    public R handleAccount(AccountView account) throws ModelException;
    public R handleAccountWrapper(AccountWrapperView accountWrapper) throws ModelException;
    
}
