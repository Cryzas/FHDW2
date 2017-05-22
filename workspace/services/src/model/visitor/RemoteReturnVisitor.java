
package model.visitor;

import persistence.*;

public interface RemoteReturnVisitor<R> extends ServiceReturnVisitor<R> {
    
    public R handleServer(Server4Public server) throws PersistenceException;
    
}
