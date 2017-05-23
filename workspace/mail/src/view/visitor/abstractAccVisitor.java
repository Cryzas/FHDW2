
package view.visitor;

import view.*;

public interface abstractAccVisitor {
    
    public void handleAccount(AccountView account) throws ModelException;
    public void handleAccountWrapper(AccountWrapperView accountWrapper) throws ModelException;
    
}
