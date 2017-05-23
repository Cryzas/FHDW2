
package view.visitor;

import view.*;

public interface abstractAccExceptionVisitor<E extends view.UserException> {
    
    public void handleAccount(AccountView account) throws ModelException, E;
    public void handleAccountWrapper(AccountWrapperView accountWrapper) throws ModelException, E;
    
}
