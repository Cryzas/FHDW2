
package model.visitor;

import persistence.*;

public interface InvokerReturnVisitor<R> extends ServiceReturnVisitor<R> {
    
    public R handleServer(Server4Public server) throws PersistenceException;
    
}
